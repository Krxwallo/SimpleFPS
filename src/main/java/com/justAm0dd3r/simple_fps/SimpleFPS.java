package com.justAm0dd3r.simple_fps;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

/**
 * Author: justAm0dd3r
 */
@Mod("simple_fps")
@Mod.EventBusSubscriber
public class SimpleFPS {
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGuiOverlayEvent.Post event) {
        if (!event.getOverlay().equals(RenderGuiOverlayEvent)) return;

        String fps = Minecraft.getInstance().fpsString.split(" ")[0];

        // white = 16777215
        Minecraft.getInstance().font.drawInBatch(event.getGuiGraphics(),
                MutableComponent.create(new TranslatableContents("gui.simple_fps.main", fps, new Object[]{})),
                3, 3, 16777215);
    }
}
