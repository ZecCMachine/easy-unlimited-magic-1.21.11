package z_cc.easy_unlimited_magic.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import fuzs.easymagic.EasyMagic;
import fuzs.easymagic.config.ServerConfig;
import fuzs.easymagic.world.inventory.ModEnchantmentMenu;
import z_cc.easy_unlimited_magic.EasyUnlimitedMagic;

@Mixin(ModEnchantmentMenu.class)
public class UnlimitEnchantingPower {
    @ModifyVariable(
        method = "updateLevelsAndClues",
        name = "enchantingPower",
        at = @At("HEAD")
    )
    private int unlimitEnchantPower(int oldEnchantPower) {
        @SuppressWarnings("null")
        int max = ((ServerConfig)EasyMagic.CONFIG.get(ServerConfig.class)).maxEnchantingPower;
        if (max == 0) {return 15;}
        int newEnchantPower = oldEnchantPower * (max/15);

        /*  COULD ADAPT EASYMAGIC CONFIG'D MAX AS MAX HERE, MAYBE AN OPTION IN CONFIG
        if (newEnchantPower >= max) {
            newEnchantPower = max;
        }
        */
       EasyUnlimitedMagic.LOGGER.info("Calculated enchant power as " + newEnchantPower + " and injected into EasyMagic by Fuzs");
        return newEnchantPower;
    }
}
