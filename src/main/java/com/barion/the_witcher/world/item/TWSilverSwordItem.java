package com.barion.the_witcher.world.item;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TWSilverSwordItem extends SwordItem {
    private final int MagicDamage;
    public TWSilverSwordItem(Tier tier, int magicDamage, float speed, Properties properties) {
        super(tier, 0, speed, properties);
        MagicDamage = magicDamage;
    }

    @Override @ParametersAreNonnullByDefault
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(target.getType().is(TWTags.Entities.MagicMob)) {
            float damage = MagicDamage;
            if(attacker instanceof Player){
                float dmgScale = ((Player) attacker).getAttackStrengthScale(0.5f) * 6.6666f;
                damage *= dmgScale;
                TheWitcher.LOGGER.info("Scaled damage with: " + dmgScale);
            }
            TheWitcher.LOGGER.info("Total Damage: " + damage);
            target.hurt(DamageSource.mobAttack(attacker), damage);
        }
        return super.hurtEnemy(itemStack, target, attacker);
    }

    @Override @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(item, level, components, flag);
        components.add(new TranslatableComponent(item.getDescriptionId() + ".info"));
    }
}