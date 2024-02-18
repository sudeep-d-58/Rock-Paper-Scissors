package game;

import move.MoveFactory;
import player.ComputerPlayerFactory;
import player.HumanPlayerFactory;
import rule.RuleEngineFactory;

public interface GameFactory extends MoveFactory, HumanPlayerFactory, ComputerPlayerFactory, RuleEngineFactory, GameResultEvaluatorFactory {

}
