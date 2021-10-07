package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.DeviceMap;

@TeleOp(name="Meacnum Control Drive V2", group="TeleOp")
public class Holonomic extends LinearOpMode {
    DeviceMap robot = new DeviceMap();
//    private DcMotor frontLeft = null;
//    private DcMotor frontRight = null;
//    private DcMotor backLeft = null;
//    private DcMotor backRight = null;
    private final double driveAdjuster = 1;

    BNO055IMU imu;
    Orientation angles;

    @Override
    public void runOpMode()  throws InterruptedException {

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.loggingEnabled = true;
        parameters.loggingTag     = "IMU";
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        telemetry.update();
        robot.FR.setDirection(DcMotor.Direction.REVERSE);
        robot.BR.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive())
        {
            if (gamepad1.right_stick_x !=0 || gamepad1.right_stick_y != 0)
            {
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                final double globalAngle = angles.firstAngle;

                final double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
                final double robotAngle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI /4;
                final double rightX = gamepad1.right_stick_x;

                double v1 = r * Math.sin(robotAngle - globalAngle/57) - rightX;
                double v2 = r * Math.cos(robotAngle - globalAngle/57) + rightX;
                double v3 = r * Math.cos(robotAngle - globalAngle/57) - rightX;
                double v4 = r * Math.sin(robotAngle - globalAngle/57) + rightX;

                if (Math.abs(v1) > 1 || Math.abs(v2) > 1 || Math.abs(v3) > 1 || Math.abs(v4) > 1 ) {
                    double max = 0;
                    max = Math.max(Math.abs(v1), Math.abs(v2));
                    max = Math.max(Math.abs(v3), max);
                    max = Math.max(Math.abs(v4), max);

                    v1 /= max;
                    v2 /= max;
                    v3 /= max;
                    v4 /= max;
                }

                robot.FR.setPower(v1);
                robot.FL.setPower(v2);
                robot.BR.setPower(v3);
                robot.BL.setPower(v4);

                telemetry.addData("Heading: ", globalAngle);
                telemetry.addData("Stick: ", robotAngle);
                telemetry.update();

            }
                else
                {
                    robot.FR.setPower(0);
                    robot.FL.setPower(0);
                    robot.BR.setPower(0);
                    robot.BL.setPower(0);
                }



            if(gamepad1.left_stick_x != 0)
            {
                robot.FR.setPower(-gamepad1.left_stick_x);
                robot.FL.setPower(gamepad1.left_stick_x);
                robot.BR.setPower(-gamepad1.left_stick_x);
                robot.BL.setPower(gamepad1.left_stick_x);
                telemetry.addData("Turning at speed", gamepad1.left_stick_x);
                telemetry.update();
            }
                else
                {
                    robot.FR.setPower(0);
                    robot.FL.setPower(0);
                    robot.BR.setPower(0);
                    robot.BL.setPower(0);
                }

        }
    }
}


