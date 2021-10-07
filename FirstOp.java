package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.DeviceMap;

@TeleOp
public class FirstOp extends OpMode
{
    DeviceMap robot = new DeviceMap();
   // private DcMotor FR, FL, BR, BL, CWheel, IL, IR, IntakeMotor;
    private double powerRY, powerRX, powerLX, powerLY, MinimumNEG, MinimumPOS, DiagMinimumNEG, DiagMinimumPOS;

    @Override
    public void init()
    {
//        FR = hardwareMap.get(DcMotor.class, "FR");
//        FL = hardwareMap.get(DcMotor.class, "FL");
//        BR = hardwareMap.get(DcMotor.class, "BR");
//        BL = hardwareMap.get(DcMotor.class, "BL");
//        CWheel = hardwareMap.get(DcMotor.class, "CW");
//
//
//        FR.setDirection(DcMotor.Direction.FORWARD);
//        FL.setDirection(DcMotor.Direction.REVERSE);
//        BR.setDirection(DcMotor.Direction.REVERSE);
//        BL.setDirection(DcMotor.Direction.FORWARD);
//        CWheel.setDirection(DcMotorSimple.Direction.FORWARD);
//
//        FR.setPower(0);
//        FL.setPower(0);
//        BR.setPower(0);
//        BL.setPower(0);
//        CWheel.setPower(0);
//
////        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
////        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
////        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
////        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
////        CWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
    }

//        double left;
//        double right;
//
//        double drive = gamepad1.left_stick_y;
//        double turn = gamepad1.left_stick_x;
//
//        left = drive+turn;
//        right = drive-turn;
//
//        robot.FL.setPower(left);
//        robot.FR.setPower(right);
//        robot.BL.setPower(left);
//        robot.BR.setPower(right);
//
//        FL.setPower(left);
//        FR.setPower(right);
//        BL.setPower(left);
//        BR.setPower(right);
//
//
//        powerRX = gamepad1.right_stick_x;
//        powerRY = gamepad1.right_stick_y;
//        powerLX = gamepad1.left_stick_x;
//        powerLY = gamepad1.left_stick_y;
//
//        if(gamepad1.right_bumper || gamepad1.left_bumper)
//        {
//            CWheel.setPower(0.6);
//        } else{CWheel.setPower(0);}
//        MinimumNEG = -0.05;
//        MinimumPOS = 0.05;
//        DiagMinimumNEG = -0.1;
//        DiagMinimumPOS = 0.1;
//
//        //Allows driver to slow down robot if wanted
//        if (gamepad1.left_bumper == true || gamepad1.right_bumper == true)
//        {
//            powerRX = powerRX/2;
//            powerRY = powerRY/2;
//            powerLX = powerLX/2;
//            powerLY = powerLY/2;
//        } else {}
//
//        //Using Right joystick
//
//        //Go Straight
//        if (gamepad1.right_stick_y > MinimumPOS && gamepad1.right_stick_x < MinimumPOS && gamepad1.right_stick_x > MinimumNEG)
//        {
//            FR.setPower(powerRY);
//            FL.setPower(powerRY);
//            BR.setPower(powerRY);
//            BL.setPower(powerRY);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Go Backwards
//        if (gamepad1.right_stick_y < MinimumNEG && gamepad1.right_stick_x < MinimumPOS && gamepad1.right_stick_x > MinimumNEG)
//        {
//            FR.setPower(powerRY);
//            FL.setPower(powerRY);
//            BR.setPower(powerRY);
//            BL.setPower(powerRY);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Strafe Left or Right
//        if ( gamepad1.right_stick_x > MinimumPOS && gamepad1.right_stick_y < MinimumPOS && gamepad1.right_stick_y > MinimumNEG)
//        {
//            FR.setPower(-powerRX);
//            FL.setPower(powerRX);
//            BR.setPower(powerRX);
//            BL.setPower(-powerRX);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        if ( gamepad1.right_stick_x < MinimumNEG && gamepad1.right_stick_y < MinimumPOS && gamepad1.right_stick_y > MinimumNEG)
//        {
//            FR.setPower(-powerRX);
//            FL.setPower(powerRX);
//            BR.setPower(powerRX);
//            BL.setPower(-powerRX);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Quadrant 1 turn right
//        if (gamepad1.right_stick_y > MinimumPOS && gamepad1.right_stick_x > MinimumPOS)
//        {
//            FR.setPower(powerRY);
//            BR.setPower(powerRY);
//            FL.setPower((powerRX+powerRY)/1.5);
//            BL.setPower((powerRX+powerRY)/1.5);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Quadrant 2 turn left
//        if (gamepad1.right_stick_y > MinimumPOS && gamepad1.right_stick_x < MinimumNEG)
//        {
//            FR.setPower(((-1*powerRX)+powerRY)/1.5);
//            BR.setPower(((-1*powerRX)+powerRY)/1.5);
//            FL.setPower(powerRY);
//            BL.setPower(powerRY);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Quadrant 3 turn back left
//        if (gamepad1.right_stick_y < MinimumNEG && gamepad1.right_stick_x < MinimumNEG)
//        {
//            FR.setPower((powerRX+powerRY)/1.5);
//            BR.setPower((powerRX+powerRY)/1.5);
//            FL.setPower(powerRY);
//            BL.setPower(powerRY);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Quadrant 4 turn back right
//        if (gamepad1.right_stick_y < MinimumNEG && gamepad1.right_stick_x > MinimumPOS)
//        {
//            FR.setPower(powerRY);
//            BR.setPower(powerRY);
//            FL.setPower(((powerRX*-1)+powerRY)/1.5);
//            BL.setPower(((powerRX*-1)+powerRY)/1.5);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Diag Up right
//        if (gamepad1.left_stick_x > DiagMinimumPOS && gamepad1.left_stick_y > DiagMinimumPOS)
//        {
//            FL.setPower(1);
//            BR.setPower(1);
//            FR.setPower(0);
//            BL.setPower(0);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Diag Up left
//        if (gamepad1.left_stick_x < DiagMinimumNEG && gamepad1.left_stick_y > DiagMinimumPOS)
//        {
//            FR.setPower(1);
//            BL.setPower(1);
//            FL.setPower(0);
//            BR.setPower(0);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Diag Down Left
//        if (gamepad1.left_stick_x < DiagMinimumNEG && gamepad1.left_stick_y < DiagMinimumNEG)
//        {
//            FL.setPower(1);
//            BR.setPower(1);
//            FR.setPower(0);
//            BL.setPower(0);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
//        //Diag Down Right
//        if (gamepad1.left_stick_x > DiagMinimumPOS && gamepad1.left_stick_y < DiagMinimumNEG)
//        {
//            FR.setPower(1);
//            BL.setPower(1);
//            FL.setPower(0);
//            BR.setPower(0);
//        }else { FR.setPower(0); FL.setPower(0); BR.setPower(0); BL.setPower(0);}
//
    }



