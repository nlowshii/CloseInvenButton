package id.nlowshii.closebutton;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;

public class CloseButtonMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (!(screen instanceof AbstractContainerScreen<?> acs)) return;

            int btnX = acs.leftPos + acs.imageWidth + 2;
            int btnY = acs.topPos;

            screen.addRenderableWidget(
                Button.builder(Component.literal("✕"), btn -> client.setScreen(null))
                    .bounds(btnX, btnY, 14, 14)
                    .tooltip(Tooltip.create(Component.translatable("gui.close")))
                    .build()
            );
        });
    }
}
