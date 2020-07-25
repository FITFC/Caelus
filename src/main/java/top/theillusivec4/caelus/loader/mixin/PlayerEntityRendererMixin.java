package top.theillusivec4.caelus.loader.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.caelus.core.client.CaelusElytraRenderer;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends
    LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {

  public PlayerEntityRendererMixin(EntityRenderDispatcher dispatcher,
      PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
    super(dispatcher, model, shadowRadius);
  }

  @Inject(method = "<init>*", at = @At("RETURN"))
  private void onConstructed(CallbackInfo cb) {
    this.addFeature(new CaelusElytraRenderer<>(this));
  }
}