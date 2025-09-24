package dev.doctor4t.trainmurdermystery.datagen;

import dev.doctor4t.trainmurdermystery.index.TMMBlocks;
import dev.doctor4t.trainmurdermystery.index.TMMEntities;
import dev.doctor4t.trainmurdermystery.index.TMMItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class TrainMurderMysteryLangGen extends FabricLanguageProvider {

    public TrainMurderMysteryLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, @NotNull TranslationBuilder builder) {
        TMMBlocks.registrar.generateLang(wrapperLookup, builder);
        TMMItems.registrar.generateLang(wrapperLookup, builder);
        TMMEntities.registrar.generateLang(wrapperLookup, builder);

//        builder.add(TMMItems.LETTER.getTranslationKey() + ".instructions", "Instructions");
//        builder.add("tip.letter.hitman.tooltip1", "Thank you for taking this job. Please eliminate the following targets:");
//        builder.add("tip.letter.hitman.tooltip.target", "- %s");
//        builder.add("tip.letter.hitman.tooltip2", "Please do so with the utmost discretion and do not get caught. Good luck.");
//        builder.add("tip.letter.hitman.tooltip3", "");
//        builder.add("tip.letter.hitman.tooltip4", "P.S.: Don't forget to use your instinct [Left Alt] and use the train's exterior to relocate.");
//
//        builder.add(TMMItems.LETTER.getTranslationKey() + ".notes", "Notes");
//        builder.add("tip.letter.detective.tooltip1", "Multiple homicides, several wealthy victims.");
//        builder.add("tip.letter.detective.tooltip2", "Have to be linked... Serial killer? Assassin? Hitman?");
//        builder.add("tip.letter.detective.tooltip3", "Potential next victims frequent travelers of the Harpy Express.");
//        builder.add("tip.letter.detective.tooltip4", "Perfect situation to corner but need to keep targets safe.");

        builder.add(TMMItems.LETTER.getTranslationKey() + ".pamphlet", "Pamphlet");
        builder.add("tip.letter.pamphlet.name", "Dear %s, welcome aboard the Harpy Express!");
        builder.add("tip.letter.pamphlet.room", "Please find attached your ticket as well as the key for accessing");
        builder.add("tip.letter.pamphlet.room.grand_suite", "the Grand Suite");
        builder.add("tip.letter.pamphlet.room.cabin_suite", "your Cabin Suite");
        builder.add("tip.letter.pamphlet.room.twin_cabin", "your Twin Cabin");
        builder.add("tip.letter.pamphlet.tooltip1", "%s for your trip on the 1st of January 1923.");
        builder.add("tip.letter.pamphlet.tooltip2", "La Sirène wishes you a pleasant and safe voyage.");

        builder.add("itemGroup.trainmurdermystery.building", "TrainMurderMystery: Building Blocks");
        builder.add("itemGroup.trainmurdermystery.decoration", "TrainMurderMystery: Decoration & Functional");
        builder.add("itemGroup.trainmurdermystery.equipment", "TrainMurderMystery: Equipment");

        builder.add("container.cargo_box", "Cargo Box");
        builder.add("container.cabinet", "Cabinet");
        builder.add("subtitles.block.cargo_box.close", "Cargo Box closes");
        builder.add("subtitles.block.cargo_box.open", "Cargo Box opens");
        builder.add("subtitles.block.door.toggle", "Door operates");

        builder.add("tip.door.locked", "This door is locked and cannot be opened.");
        builder.add("tip.door.requires_key", "This door is locked and requires a key to be opened.");
        builder.add("tip.door.requires_different_key", "This door is locked and requires a different key to be opened.");
        builder.add("tip.door.jammed", "This door is jammed and cannot be opened at the moment!");

        builder.add("tip.cooldown", "On cooldown: %s");
        builder.add("tip.knife.tooltip1", "Right-click to use, hold for a second and get close to your victim!");
        builder.add("tip.knife.tooltip2", "After a kill, cannot be used for 3 minutes");
        builder.add("tip.knife.tooltip3", "Attack to knock back / push a player (no cooldown)");
        builder.add("tip.lockpick.tooltip1", "Use on any locked door to open it (no cooldown)");
        builder.add("tip.lockpick.tooltip2", "Sneak-use on a door to jam it for 1 minute (disables the lockpick for 5 minutes)");
        builder.add("tip.revolver.rounds", "%s/6 rounds left");
        builder.add("tip.revolver.tooltip1", "Right-click to use, point and shoot");
        builder.add("tip.revolver.tooltip2", "Can be used to shoot a door and open it permanently (only glass and wooden doors)");
        builder.add("tip.body_bag.tooltip1", "Use on a dead body to bag it up and remove it");
        builder.add("tip.blackout.tooltip1", "Trigger a blackout");
        builder.add("tip.blackout.tooltip2", "Activated instantly on purchase");
        builder.add("tip.blackout.tooltip3", "More placeholder text");
        builder.add("tip.disguise.tooltip1", "Disguise yourself for a bit");
        builder.add("tip.disguise.tooltip2", "Activated instantly on purchase");
        builder.add("tip.disguise.tooltip3", "More placeholder text");

        builder.add("game.win.hitmen", "The hitmen reached their kill count, they win!");
        builder.add("game.win.passengers", "All hitmen were eliminated: the passengers win!");

        builder.add("key.trainmurdermystery.instinct", "Instinct");
        builder.add("category.trainmurdermystery.keybinds", "Train Murder Mystery");

        builder.add("task.sleep", "You feel like getting some sleep.");
        builder.add("task.outside", "You feel like getting some fresh air.");
        builder.add("task.drink", "You feel like getting a drink.");
        builder.add("task.eat", "You feel like getting a snack.");
        builder.add("game.player.stung", "You feel something stinging you in your sleep.");
        builder.add("game.psycho_mode.time", "Psycho Mode: %s");
        builder.add("game.psycho_mode.over", "Psycho Mode Over!");
    }
}
