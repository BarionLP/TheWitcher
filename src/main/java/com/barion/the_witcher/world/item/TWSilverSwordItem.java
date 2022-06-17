package com.barion.the_witcher.world.item;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TWSilverSwordItem extends SwordItem {
    private final int MagicDamage;
    private final TranslatableComponent MagicDamageInfo;
    public TWSilverSwordItem(Tier tier, int magicDamage, float attackSpeed, Properties properties) {
        super(tier, 0, attackSpeed, properties);
        MagicDamage = magicDamage;
        MagicDamageInfo  = new TranslatableComponent("item.the_witcher.silver_sword.info", MagicDamage);
    }

    @Override @ParametersAreNonnullByDefault
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(target.getType().is(TWTags.Entities.MagicMob)) {
            float damage = MagicDamage;
            float enchantmentBonus;
            enchantmentBonus = EnchantmentHelper.getDamageBonus(attacker.getMainHandItem(), target.getMobType());
            if(attacker instanceof Player){
                float dmgScale = ((Player) attacker).getAttackStrengthScale(0.5f);
                damage *= 0.2f + dmgScale * dmgScale * 0.8f;
                enchantmentBonus *= dmgScale;
                TheWitcher.Logger.info("Scaled damage with: " + 0.2f + dmgScale * dmgScale * 0.8f);
            }
            damage += enchantmentBonus;
            TheWitcher.Logger.info("Total Damage: " + damage);
            target.hurt(DamageSource.mobAttack(attacker), damage);
        }
        return super.hurtEnemy(itemStack, target, attacker);
    }

    @Override @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(item, level, components, flag);
        components.add(MagicDamageInfo);
    }
}