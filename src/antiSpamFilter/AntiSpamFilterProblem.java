package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import mechanisms.Evaluation;
import mechanisms.FileReader;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	private static final long serialVersionUID = 1L;

	public AntiSpamFilterProblem() {
	    this(FileReader.getRules_list().size());
	  }

	  public AntiSpamFilterProblem(Integer numberOfVariables) {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("AntiSpamFilterProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5.0);
	      upperLimit.add(5.0);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){
	    double[] x = new double[getNumberOfVariables()];
	    
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      x[i] = solution.getVariableValue(i) ;
	    }
	   int[] a = Evaluation.evaluate(x);

	    solution.setObjective(0, a[0]);
	    solution.setObjective(1, a[1]);
	  }

	}