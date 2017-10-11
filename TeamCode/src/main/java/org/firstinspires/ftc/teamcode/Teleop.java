package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "Tele-op", group = "Robot")
@SuppressWarnings("unused")
public class Teleop extends OpMode {
    RobotHardware robot = new RobotHardware(telemetry);

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        updateTelemetry(telemetry);
        //Standard drive system

        if(gamepad1.left_stick_y < -.25 || gamepad1.left_stick_x > .25){
            robot.leftDrive(-gamepad1.left_stick_y);
            robot.rightDrive(-gamepad1.left_stick_y);
        }
        if(gamepad1.left_stick_x < -.25 || gamepad1.left_stick_x > .25)
            robot.centerWheel.setPower(-gamepad1.left_stick_x);
        if(gamepad1.right_stick_x < -.25){
            robot.leftDrive(-gamepad1.right_stick_x);
            robot.rightDrive(gamepad1.right_stick_x);
        }
        if(gamepad1.right_stick_x > .25){
            robot.leftDrive(gamepad1.right_stick_x);
            robot.rightDrive(-gamepad1.right_stick_x);
        }
        robot.armMotor.setPower(-gamepad2.right_stick_y);

        //Reset encoders` for testing purposes
        if (gamepad1.a) {
            robot.leftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.rightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.centerWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.centerWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            robot.armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        //Telemetry
//        telemetry.addData("Shooter Encoders L/R", robot.leftShooter.getCurrentPosition() + "/" + robot.rightShooter.getCurrentPosition());
//        telemetry.addData("Range Sensor 1", robot.rangeRead());
//        telemetry.addData("Range Sensor 2", robot.rangeRead2());
        telemetry.addData("Left Encoder", robot.leftWheel.getCurrentPosition());
        telemetry.addData("Right Encoder", robot.rightWheel.getCurrentPosition());
        telemetry.addData("Center Encoder", robot.centerWheel.getCurrentPosition());
        telemetry.addData("Arm Encoder", robot.armMotor.getCurrentPosition());
        telemetry.update();

        // Code to run ONCE after the driver hits STOP

    }

    @Override
    public void stop() {
        robot.stopDrive();
    }
}

