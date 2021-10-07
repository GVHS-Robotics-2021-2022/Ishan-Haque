package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.DeviceMap;


@Autonomous
public class AutonOpEg extends LinearOpMode
{
    
    DeviceMap robot = new DeviceMap();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fb(2000, 0.7);
        right(4000, 0.9);
        fb(2000, 0.7);
        left(4000, 0.9);
    }

    public void fb(int ms, double s)
    {
        robot.FL.setPower(s);
        robot.FR.setPower(s);
        robot.BL.setPower(s);
        robot.BR.setPower(s);
        sleep(ms);
    }

    public void right(int ms, double s)
    {
        robot.FL.setPower(s);
        robot.FR.setPower(-s);
        robot.BL.setPower(s);
        robot.BR.setPower(-s);
        sleep(ms);
    }

    public void left(int ms, double s)
    {
        robot.FL.setPower(-s);
        robot.FR.setPower(s);
        robot.BL.setPower(-s);
        robot.BR.setPower(s);
        sleep(ms);
    }
}
