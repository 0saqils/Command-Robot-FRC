package frc.robot.commands;

import java.util.function.DoubleSupplier;

import javax.swing.text.html.parser.DTD;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.XRPDrivetrain;

public class DriveCommand extends Command{
    private final XRPDrivetrain dtrains;
    private final DoubleSupplier rotations;
    private final DoubleSupplier directions;


    public DriveCommand (XRPDrivetrain dtrain, DoubleSupplier rotation, DoubleSupplier direction) {
        dtrains = dtrain;
        rotations = rotation;
        directions = direction;
        addRequirements(dtrain);
    }
    @Override
  public void initialize() {
      dtrains.resetEncoders();
  } 
    

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dtrains.arcadeDrive(directions.getAsDouble(), rotations.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dtrains.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}