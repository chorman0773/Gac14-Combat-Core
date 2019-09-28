package github.chorman0773.gac14.combat.core;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gac14-combat-core")
public class Gac14CombatCore
{
    
	@CapabilityInject(CombatTimer.class)
	public static final Capability<CombatTimer> COMBAT_TIMER = null;
	
	public Gac14CombatCore() {
		MinecraftForge.EVENT_BUS.addListener(this::setup);
	}
	
	private void setup(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(CombatTimer.class, new IStorage<CombatTimer>() {

			@Override
			public INBT writeNBT(Capability<CombatTimer> capability, CombatTimer instance, Direction side) {
				return null;
			}

			@Override
			public void readNBT(Capability<CombatTimer> capability, CombatTimer instance, Direction side, INBT nbt) {
			}
		}, ()->null);
	}
}
