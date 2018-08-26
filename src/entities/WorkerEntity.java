package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.ContractTypeEnum;
import enums.WorkerFunctionEnum;
import enums.WorkerStatusEnum;

public class WorkerEntity {

        String id;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public WorkerStatusEnum getStatus() {
                return status;
        }

        public void setStatus(WorkerStatusEnum status) {
                this.status = status;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSurname() {
                return surname;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public String getPesel() {
                return pesel;
        }

        public void setPesel(String pesel) {
                this.pesel = pesel;
        }

        public String getJob() {
                return job;
        }

        public void setJob(String job) {
                this.job = job;
        }

        public WorkerFunctionEnum getFunction() {
                return function;
        }

        public void setFunction(WorkerFunctionEnum function) {
                this.function = function;
        }

        public ContractTypeEnum getContractType() {
                return contractType;
        }

        public void setContractType(ContractTypeEnum contractType) {
                this.contractType = contractType;
        }

        public Double getSalary() {
                return salary;
        }

        public void setSalary(Double salary) {
                this.salary = salary;
        }

        public String getScientificTitle() {
                return scientificTitle;
        }

        public void setScientificTitle(String scientificTitle) {
                this.scientificTitle = scientificTitle;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public Integer getRemainigVacation() {
                return remainigVacation;
        }

        public void setRemainigVacation(Integer remainigVacation) {
                this.remainigVacation = remainigVacation;
        }

        private WorkerStatusEnum status;
        private String name;
        private String surname;
        private String pesel;
        private String job;
        private WorkerFunctionEnum function;
        private ContractTypeEnum contractType;
        private Double salary;
        private String scientificTitle;
        private Integer age;
        private Integer remainigVacation;

        public DBObject toDBObject() {
                return new BasicDBObject("name", this.getName())
                        .append("surname", this.getSurname())
                        .append("pesel", this.getPesel())
                        .append("job", this.getJob())
                        .append("salary", this.getSalary())
                        .append("title", this.getScientificTitle())
                        .append("age", this.getAge())
                        .append("remainingVacation", this.getRemainigVacation())
                        .append("status", this.getStatus())
                        .append("function", this.getFunction())
                        .append("contractType", this.getRemainigVacation());

        }

}
