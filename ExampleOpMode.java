package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class ExampleOpMode extends OpMode
{
    private double powerLX, powerLY, powerRX, powerRY;
    DeviceMap robot = new DeviceMap();


    @Override
    public void init()
    {

    }

    @Override
    public void loop()
    {
        powerLX = gamepad1.left_stick_x;
        powerLY = gamepad1.left_stick_y;
        powerRX = gamepad1.right_stick_x;
        powerRY = gamepad1.right_stick_y;

        if(powerLY > 0.07 || powerLY < -0.07)
        {
            robot.FL.setPower(powerLY);
            robot.BL.setPower(powerLY);
        } else
            {
               robot.FL.setPower(0);
               robot.BL.setPower(0);
            }

        if(powerRY > 0.07 || powerRY < -0.07)
        {
            robot.FR.setPower(powerRY);
            robot.BR.setPower(powerRY);
        } else
        {
            robot.FR.setPower(0);
            robot.BR.setPower(0);
        }









//        if((powerLY > 0.1 || powerLY < -0.1) && (powerLX < 0.1 && powerLX > -0.1))
//        {
//            robot.FR.setPower(powerLY);
//            robot.FL.setPower(powerLY);
//            robot.BR.setPower(powerLY);
//            robot.FL.setPower(powerLY);
//
//        }
//            else
//                {
//                    robot.FR.setPower(0);
//                    robot.FL.setPower(0);
//                    robot.BR.setPower(0);
//                    robot.FL.setPower(0);
//                }
//
//        if((powerLX > 0.1 || powerLX < -0.1) && (powerLY < 0.1 && powerLY > -0.1))
//        {
//            robot.FR.setPower(-powerLX);
//            robot.FL.setPower(powerLX);
//            robot.BR.setPower(-powerLX);
//            robot.FL.setPower(powerLX);
//        }
//            else
//                {
//                    robot.FR.setPower(0);
//                    robot.FL.setPower(0);
//                    robot.BR.setPower(0);
//                    robot.FL.setPower(0);
//                }


    }
}
