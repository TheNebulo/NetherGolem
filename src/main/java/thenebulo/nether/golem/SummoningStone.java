package thenebulo.nether.golem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import thenebulo.nether.golem.particle.ModParticles;


public class SummoningStone extends Item {
 
    public SummoningStone(Settings settings) {
        super(settings);
    }

    public Vec3d LerpByDistance(Vec3d A, Vec3d B, float x)
    {
        Vec3d P = ((B.subtract(A)).normalize().multiply(x)).add(A);
        return P;
    }

    public Vec3d GetDirection(PlayerEntity player){
        return new Vec3d(player.getPitch(), player.getYaw(), player.getRoll());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
           user.playSound(SoundEvents.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
           Vec3d target = user.raycast(10000, 1f, true).getPos();
           HitResult hit = user.raycast(10000, 1f, true);
           Block block = null;
           switch(hit.getType()) {
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockPos = blockHit.getBlockPos();
                BlockState blockState = world.getBlockState(blockPos);
                block = blockState.getBlock();
                break; 
            default:
                break; 
        }
           Vec3d loc = user.raycast(1, 1f, true).getPos();
           for(int i = 1; i < 1000001; i++) {
                Vec3d pos = LerpByDistance(loc, target, i/10);
                world.addParticle(ModParticles.SUMMONING_STONE_PARTICLE, pos.x, pos.y, pos.z, 1,1,1);
           }
           if (user.world.getRegistryKey() == World.NETHER ){
            if(block.equals(Blocks.LAVA)){
                Text text = Text.of("The ground trembles...");
                user.sendMessage(text, true);
                user.getInventory().removeOne(user.getStackInHand(hand));
                user.playSound(SoundEvents.ENTITY_WARDEN_EMERGE, 1.0F, 1.0F);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 10));
                user.playSound(SoundEvents.ENTITY_WARDEN_HEARTBEAT, 1.0F, 1.0F);
            }
            else{
                Text text = Text.of("Lava is the last piece of the riual");
                user.sendMessage(text, true);
            }
           }
           else{
            Text text = Text.of("The Golem lies in the Nether");
            user.sendMessage(text, true);
           }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
