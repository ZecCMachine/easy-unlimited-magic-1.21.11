package z_cc.easy_unlimited_magic;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyUnlimitedMagic implements ModInitializer {
	public static final String MOD_ID = "easy-unlimited-magic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("LOADED EasyUnlimitedMagic by Z_cC.  Hello there!");
	}
}