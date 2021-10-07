package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DeviceMap;

@Autonomous(name = "Auto")
public class AutonOpMode extends LinearOpMode
{
    DeviceMap robot = new DeviceMap();
    private ElapsedTime runtime = new ElapsedTime();

    static final double cpmr = 1440;
    //Count Per Motor Rev

    static final double dgr = 2.0;
    //Drive gear reduction

    static final double wdi = 4.0;
    //Wheel diameter in inches

    static final double cpi = (cpmr+dgr)/(wdi);
    //Counts per inch

    static final double ds = 0.6;
    //Drive speed

    static final double ts = 0.5;
    //Turn speed

    @Override
    public void runOpMode() throws InterruptedException
    {
        robot.init();
        telemetry.addData("Status, ", "Resetting Encoders");
        telemetry.update();

        robot.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Path", "Starting at %7d, :%7d", robot.FL.getCurrentPosition(), robot.FR.getCurrentPosition());
        telemetry.update();

        waitForStart();

        EncoderDrive(ds, 48, 48, 5);
        //Forward
        EncoderDrive(ts, 12, -12, 4);
        //Turn Right
        EncoderDrive(ds, -24, -24, 5);
        //Backward
        EncoderDrive(ts, -12, 12, 4);
        //Turn Left

        sleep(1000);

    }

    public void EncoderDrive(double speed, double lefti, double righti, double timeoutS)
    {

        int nlt;
        //New Left Target
        int nlt2;
        //New Left Target 2
        int nrt;
        //New Right Target
        int nrt2;
        //New Right Target 2

        if (opModeIsActive())
        {
            nlt = robot.FL.getCurrentPosition() + (int)(lefti * cpi);
            nlt2 = robot.BL.getCurrentPosition() + (int)(lefti * cpi);
            nrt = robot.FR.getCurrentPosition() + (int)(righti * cpi);
            nrt2 = robot.BR.getCurrentPosition() + (int)(righti * cpi);

            robot.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            robot.FL.setPower(Math.abs(speed));
            robot.BL.setPower(Math.abs(speed));
            robot.FR.setPower(Math.abs(speed));
            robot.BR.setPower(Math.abs(speed));

            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (robot.FL.isBusy() && robot.FR.isBusy() && robot.BL.isBusy() && robot.BR.isBusy()))
            {
                telemetry.addData("Path1", "Running to %7d :%7d", nlt, nrt);
                telemetry.addData("Path2", "Running to %7d, :%7d", robot.FL.getCurrentPosition(), robot.FR.getCurrentPosition());
                telemetry.update();
            }

            robot.FL.setPower(0);
            robot.BL.setPower(0);
            robot.FR.setPower(0);
            robot.BR.setPower(0);

            robot.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
