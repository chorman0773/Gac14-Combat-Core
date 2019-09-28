package github.chorman0773.gac14.combat.core;

public interface CombatTimer {
	/**
	 * Checks if the player is in combat
	 * @return
	 */
	public boolean isInCombat();
	public void enterCombat();
	public void leaveCombat();
	public void disconnectKillPlayer();
	public void setCombatTime(int ticks);
	public boolean canBeInCombat();
}
