package entities;

import enums.ContractTypeEnum;
import enums.WorkerFunctionEnum;
import enums.WorkerStatusEnum;

public class WorkerEntity {

        WorkerStatusEnum status;
        String name;
        String surname;
        String pesel;
        String job;
        WorkerFunctionEnum function;
        ContractTypeEnum contractType;
        Double salary;
        String scientificTitle;
        Integer age;
        Integer remainigVacation;


}
