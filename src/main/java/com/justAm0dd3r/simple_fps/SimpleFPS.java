package com.justAm0dd3r.simple_fps;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: justAm0dd3r
 */
@Mod("simple_fps")
@Mod.EventBusSubscriber
public class SimpleFPS {
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        if (!event.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) return;

        String fps = Minecraft.getInstance().fpsString.split(" ")[0];

        // white = 16777215
        Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.simple_fps.main", fps), 3, 3, 16777215);
    }
}
