package gg.oddysian.adenydd.clienttimechanger.listeners;

import gg.oddysian.adenydd.clienttimechanger.ClientTimeChanger;
import gg.oddysian.adenydd.clienttimechanger.enums.TimeTypes;
import gg.oddysian.adenydd.clienttimechanger.handler.TimeChangerNetHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.INetHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientListener {

    public ClientListener() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = ClientTimeChanger.INSTANCE.mc;
        if (mc.world != null) {
            INetHandler parent = mc.player.connection.getNetworkManager().getNetHandler();
            if (!(parent instanceof TimeChangerNetHandler))
                mc.player.connection.getNetworkManager().setNetHandler(new TimeChangerNetHandler((NetHandlerPlayClient)parent));
            if (TIME_TYPE == TimeTypes.FAST)
                mc.world.setWorldTime((long)(System.currentTimeMillis() * fastTimeMultiplier % 24000.0D));
        }
    }

    public static TimeTypes TIME_TYPE = TimeTypes.VANILLA;

    public static double fastTimeMultiplier = 1.0D;
}
