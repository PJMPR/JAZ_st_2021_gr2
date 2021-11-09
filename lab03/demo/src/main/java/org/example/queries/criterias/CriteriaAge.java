package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CriteriaBase implements Criteria{

   @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters searchParameters) {
        this.parameters = searchParameters;
        if(checkParameters()) {
            persons = persons.stream()
                    .filter(person -> checkCriteria(person))
                    .collect(Collectors.toList());
        }
    }
        protected SearchParameters parameters;
        protected abstract boolean checkParameters();
        protected abstract boolean checkCriteria(Person p);
    
        
}

public class SimpleCriteria extends CriteriaBase{
    Predicate<SearchParameters> checkParams;
    Predicate<Person> checkPerson;
    
    public SimpleCriteria(Predicate<SearchParameters> checkParams, Predicate<Person> checkPerson){
        this.checkPerson=checkPerson;
        this.checkParams = checkParams;
    }
    
    protected boolean checkParameters(){
        return this.checkParams.check(parameters);
    }

    
    protected boolean checkCriteria(Person p){
        return this.checkPerson.check(p);
    }
    
}

public class CriteriaAgeFrom extends CriteriaBase {

    protected boolean checkParameters(){
        return parameters.getAgeFrom()>0;
    }

    
    protected boolean checkCriteria(Person p){
        return p.getAge()>parameters.getAgeFrom;
    }
}
