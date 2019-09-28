package github.chorman0773.gac14.combat.core.event;

import github.chorman0773.gac14.combat.core.CombatTimer;
import github.chorman0773.gac14.combat.core.Gac14CombatCore;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="gac14-combat-core")
public class Handlers {

	private Handlers() {
	}
	
	@SubscribeEvent
	public static void beginCombat(LivingAttackEvent attack) {
		if(attack.getEntityLiving() instanceof PlayerEntity){
			PlayerEntity attacked = (PlayerEntity)attack.getEntityLiving();
			assert Gac14CombatCore.COMBAT_TIMER != null;
			attacked
				.getCapability(Gac14CombatCore.COMBAT_TIMER)
				.filter(CombatTimer::canBeInCombat)
				.ifPresent(CombatTimer::enterCombat);
			if(attack.getSource().getTrueSource() instanceof PlayerEntity) {
				PlayerEntity attacker = (PlayerEntity)attack.getSource().getTrueSource();
				attacker
					.getCapability(Gac14CombatCore.COMBAT_TIMER)
					.filter(CombatTimer::canBeInCombat)
					.ifPresent(CombatTimer::enterCombat);
			}
		}
	}
	
	@SubscribeEvent
	public static void logoutKillPlayer(PlayerEvent.PlayerLoggedOutEvent event) {
		event.getPlayer()
		.getCapability(Gac14CombatCore.COMBAT_TIMER)
		.filter(CombatTimer::isInCombat)
		.ifPresent(CombatTimer::disconnectKillPlayer);
	}

}
