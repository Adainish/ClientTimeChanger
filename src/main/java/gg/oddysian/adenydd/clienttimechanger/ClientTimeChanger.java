package gg.oddysian.adenydd.clienttimechanger;

import gg.oddysian.adenydd.clienttimechanger.commands.*;
import gg.oddysian.adenydd.clienttimechanger.listeners.ClientListener;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = ClientTimeChanger.MOD_ID,
        name = ClientTimeChanger.MOD_NAME,
        version = ClientTimeChanger.VERSION,
        clientSideOnly = true

)
public class ClientTimeChanger {

    public static final String MOD_ID = "clienttimechanger";
    public static final String MOD_NAME = "ClientTimeChanger";
    public static final String VERSION = "1.0-Client";
    public Minecraft mc = Minecraft.getMinecraft();
    public static ClientListener clientListener;
    @Mod.Instance(MOD_ID)
    public static ClientTimeChanger INSTANCE;


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        clientListener = new ClientListener();
        ClientCommandHandler.instance.registerCommand(new VanillaTimeCommand());
        ClientCommandHandler.instance.registerCommand(new FastTimeCommand());
        ClientCommandHandler.instance.registerCommand(new DayCommand());
        ClientCommandHandler.instance.registerCommand(new NightCommand());
        ClientCommandHandler.instance.registerCommand(new SunsetCommand());
    }


}
