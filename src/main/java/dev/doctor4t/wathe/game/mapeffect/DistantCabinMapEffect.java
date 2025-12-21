package dev.doctor4t.wathe.game.mapeffect;

import dev.doctor4t.wathe.api.MapEffect;
import dev.doctor4t.wathe.cca.MapVariablesWorldComponent;
import dev.doctor4t.wathe.cca.TrainWorldComponent;
import dev.doctor4t.wathe.index.WatheItems;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class DistantCabinMapEffect extends MapEffect {
    /**
     * @param identifier the map effect identifier
     */
    public DistantCabinMapEffect(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void initializeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {
        TrainWorldComponent trainWorldComponent = TrainWorldComponent.KEY.get(serverWorld);
        trainWorldComponent.setSnow(false);
        trainWorldComponent.setFog(true);
        trainWorldComponent.setHud(true);
        trainWorldComponent.setSpeed(0);
        trainWorldComponent.setTime(0);
        serverWorld.setWeather(0, 10000000, true, false);
        Collections.shuffle(players);

        int firstRoomSkips = 2;
        int roomNumber = 0;
        for (ServerPlayerEntity serverPlayerEntity : players) {
            ItemStack itemStack = new ItemStack(WatheItems.KEY);
            roomNumber = roomNumber % MapVariablesWorldComponent.KEY.get(serverWorld).getMaxRoomKey() + 1;
            if (roomNumber == 1 && firstRoomSkips > 0) {
                roomNumber++;
                firstRoomSkips--;
            }
            int finalRoomNumber = roomNumber;
            String str = "Room " + finalRoomNumber;
            switch (finalRoomNumber) {
                case 1 -> str = "Backwoods Sauna";
                case 2 -> str = "Eastern Cabin";
                case 3 -> str = "Western Cabin";
            }
            final String finalStr = str;
            itemStack.apply(DataComponentTypes.LORE, LoreComponent.DEFAULT, component -> new LoreComponent(Text.literal(finalStr).getWithStyle(Style.EMPTY.withItalic(false).withColor(0xFF8C00))));
            ItemStack commonKey = new ItemStack(WatheItems.KEY);
            commonKey.apply(DataComponentTypes.LORE, LoreComponent.DEFAULT, component -> new LoreComponent(Text.literal("Guest").getWithStyle(Style.EMPTY.withItalic(false).withColor(0xFF8C00))));
            serverPlayerEntity.giveItemStack(itemStack);
            serverPlayerEntity.giveItemStack(commonKey);

            // give letter
            ItemStack letter = new ItemStack(WatheItems.LETTER);

            letter.set(DataComponentTypes.ITEM_NAME, Text.translatable(letter.getTranslationKey()));
            int letterColor = 0xC5AE8B;
            String tipString = "tip.letter.distant_cabin.";
            letter.apply(DataComponentTypes.LORE, LoreComponent.DEFAULT, component -> {
                        List<Text> text = new ArrayList<>();
                        UnaryOperator<Style> stylizer = style -> style.withItalic(false).withColor(letterColor);

                        Text displayName = serverPlayerEntity.getDisplayName();
                        String string = displayName != null ? displayName.getString() : serverPlayerEntity.getName().getString();
                        if (string.charAt(string.length() - 1) == '\uE780') { // remove ratty supporter icon
                            string = string.substring(0, string.length() - 1);
                        }

                        text.add(Text.translatable(tipString + "name", string).styled(style -> style.withItalic(false).withColor(0xFFFFFF)));
                        text.add(Text.translatable(tipString + "tooltip1").styled(stylizer));
                        text.add(Text.translatable(tipString + "tooltip2").styled(stylizer));
                        text.add(Text.translatable(tipString + "tooltip3").styled(stylizer));
                        text.add(Text.translatable(tipString + "room",
                                Text.translatable(tipString + "room." + switch (finalRoomNumber) {
                                    case 1 -> "sauna_cabin";
                                    case 2 -> "east_cabin";
                                    case 3 -> "west_cabin";
                                    default -> "unknown";
                                }).getString()
                        ).styled(stylizer));

                        return new LoreComponent(text);
                    }
            );
            serverPlayerEntity.giveItemStack(letter);
        }
    }

    @Override
    public void finalizeMapEffects(ServerWorld serverWorld, List<ServerPlayerEntity> players) {

    }
}
