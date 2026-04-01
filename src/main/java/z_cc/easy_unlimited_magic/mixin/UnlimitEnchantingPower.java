package z_cc.easy_unlimited_magic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import fuzs.easymagic.EasyMagic;
import fuzs.easymagic.config.ServerConfig;
import fuzs.easymagic.world.inventory.ModEnchantmentMenu;

@Mixin(ModEnchantmentMenu.class)
public class UnlimitEnchantingPower {
    @SuppressWarnings("null")
    @ModifyVariable(
        method = "updateLevelsAndClues",
        name = "enchantingPower",
        at = @At("HEAD")
    )
    private int unlimitEnchantPower(int oldEnchantPower) {
        int max = ((ServerConfig)EasyMagic.CONFIG.get(ServerConfig.class)).maxEnchantingPower;
        int newEnchantPower = max != 0 ? 15 : oldEnchantPower / 15 * max;
        if (newEnchantPower >= max) {
            newEnchantPower = max;
        }
        return newEnchantPower;
    }
}
