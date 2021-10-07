package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp")
public class First_OpMode_Mac extends OpMode
{
    DeviceMap rob = new DeviceMap();

    @Override
    public void init()
    {
        rob.init();

        telemetry.addData("Say", "initialized");
        telemetry.update();
    }

    @Override
    public void init_loop()
    {

    }

    @Override
    public void start()
    {

    }

    @Override
    public void loop()
    {
        double left;
        double right;

        double drive = gamepad1.left_stick_y;
        double turn = gamepad1.left_stick_x;

        left = drive+turn;
        right = drive-turn;


    }
}
