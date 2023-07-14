package com.justAm0dd3r.simple_fps;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.TextComponentHelper;

/**
 * Author: Krxwallo
 */
@Mod("simple_fps")
@Mod.EventBusSubscriber
public class SimpleFPS {
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGuiOverlayEvent.Post event) {
        if (Minecraft.getInstance().options.renderDebug) return;

        int fps = Minecraft.getInstance().getFps();
        Component fpsComponent = TextComponentHelper.createComponentTranslation(Minecraft.getInstance().player, "gui.simple_fps.main", fps);

        // white = 16777215
        event.getGuiGraphics().drawString(Minecraft.getInstance().font, fpsComponent, 3, 3, 16777215);
    }
}
