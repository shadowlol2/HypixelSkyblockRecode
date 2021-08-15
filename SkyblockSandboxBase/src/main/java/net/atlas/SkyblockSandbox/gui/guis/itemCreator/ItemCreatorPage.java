package net.atlas.SkyblockSandbox.gui.guis.itemCreator;

import net.atlas.SkyblockSandbox.gui.SBGUI;
//import net.atlas.SkyblockSandbox.gui.guis.itemCreator.pages.AbilityCreator.*;
import net.atlas.SkyblockSandbox.gui.guis.itemCreator.pages.ItemCreatorGUIMain;
import net.atlas.SkyblockSandbox.gui.guis.itemCreator.pages.ItemLoreGUI;
import net.atlas.SkyblockSandbox.gui.guis.itemCreator.pages.RaritiesGUI;
import net.atlas.SkyblockSandbox.gui.guis.itemCreator.pages.StatsEditorGUI;
import net.atlas.SkyblockSandbox.player.SBPlayer;
import org.apache.commons.lang.reflect.ConstructorUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

import static java.lang.System.out;

public enum ItemCreatorPage {
    MAIN(ItemCreatorGUIMain.class),
    SET_LORE(ItemLoreGUI.class),
    SET_RARITY(RaritiesGUI.class),
    STATS_EDITOR(StatsEditorGUI.class),
    ;
    /*ABILITY_EDITOR(AbilityEditorGUI.class),
    ABILITY_CREATOR_GUI_MAIN(AbilityCreatorGUI.class),
    ABILITY_DESCRIPTION_PICKER(AbilityDescriptionPicker.class),
    BASE_ABILITIES(BaseAbilitiesGUI.class),
    ENTITY_SHOOTER(EntityShooterGUI.class),
    FUNCTIONS_CREATOR(FunctionsCreatorGUI.class),
    FUNCTIONS_EDITOR(FunctionsEditorGUI.class),
    FUNCTIONS_GUI_MAIN(FunctionsGUI.class),
    HEAD_CHOOSER(HeadChooserGUI.class),
    PARTICLE_CHOOSER(ParticleChooserGUI.class),
    PARTICLE_SHOOTER(ParticleShooterGUI.class),
    SET_ABILITY_DESCRIPTION(SetAbilityDescriptionMenu.class),
    SHAPE_SELECTOR(ShapeSlectorGUI.class),
    SOUND_CHOOSER(SoundChooserGUI.class);*/


    private Class<? extends SBGUI> gui;

    ItemCreatorPage(Class<? extends SBGUI> gui) {
        this.gui = gui;
    }

    public SBGUI getGui(SBPlayer pl) {
        try {
            return (SBGUI) ConstructorUtils.invokeConstructor(gui, pl);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SBGUI getGui(SBPlayer pl,int index) {
        try {
            return (SBGUI) ConstructorUtils.invokeConstructor(gui, new Object[]{pl,index});
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SBGUI getGui(SBPlayer pl,int index,int indexx) {
        try {
            return (SBGUI) ConstructorUtils.invokeConstructor(gui, new Object[]{pl,index,indexx});
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
