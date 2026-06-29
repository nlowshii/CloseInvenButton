package id.nlowshii.closebutton;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.text.Text;

public class CloseButtonMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (!(screen instanceof HandledScreen<?> hs)) return;

            int btnX = hs.x + hs.backgroundWidth + 2;
            int btnY = hs.y;

            screen.addDrawableChild(
                ButtonWidget.builder(Text.literal("✕"), btn -> screen.close())
                    .dimensions(btnX, btnY, 14, 14)
                    .tooltip(Tooltip.of(Text.translatable("gui.close")))
                    .build()
            );
        });
    }
}
