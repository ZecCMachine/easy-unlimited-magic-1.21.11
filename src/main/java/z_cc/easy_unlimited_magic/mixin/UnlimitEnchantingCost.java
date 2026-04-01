package z_cc.easy_unlimited_magic.mixin;

import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import z_cc.easy_unlimited_magic.EasyUnlimitedMagic;

@Debug(export = true)
@Mixin(EnchantmentHelper.class)
public class UnlimitEnchantingCost {
    @Expression("? > 15")
    @ModifyExpressionValue(
        method = "getEnchantmentCost",
        at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean UnlimitEnchantCost(boolean originalExpression) {
        // Disables the expression that limits the value the enchantment cost
        return false;
    }

    @ModifyReturnValue(
        method = "getEnchantmentCost",
        at = @At("RETURN")
    )
    private static int logEnchantCost(int returnValue) {
        EasyUnlimitedMagic.LOGGER.info("Calculated Enchant Cost is " + returnValue);
        return returnValue;
    }
}
