package com.justAm0dd3r.simple_fps.events;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

/**
 * Author: justAm0dd3r
 */
@Mod.EventBusSubscriber
public class Events {
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (!event.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) return;

        int fps = -1;

        try {
            Field fpsField = Minecraft.class.getDeclaredField("debugFPS");
            fpsField.setAccessible(true);
            fps = (int)fpsField.get(Minecraft.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        String fpsString;
        if (fps == -1) fpsString = "?";
        else           fpsString = String.valueOf(fps);

        //noinspection ConstantConditions // TextFormatting.WHITE.getColor() is not null!
        Minecraft.getInstance().fontRenderer.func_238407_a_(event.getMatrixStack(), new TranslationTextComponent("gui.simple_fps.main", fpsString), 3, 3, TextFormatting.WHITE.getColor());
    }
}
