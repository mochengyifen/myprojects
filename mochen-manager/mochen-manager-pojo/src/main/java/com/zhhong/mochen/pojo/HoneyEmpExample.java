package com.zhhong.mochen.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoneyEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer startRow;

    protected Integer pageSize;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public HoneyEmpExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(String value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(String value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(String value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(String value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(String value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(String value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLike(String value) {
            addCriterion("empId like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotLike(String value) {
            addCriterion("empId not like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<String> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<String> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(String value1, String value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(String value1, String value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empName is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empName is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empName =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empName <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empName >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empName >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empName <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empName <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empName like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empName not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empName in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empName not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empName between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empName not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIsNull() {
            addCriterion("empPhone is null");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIsNotNull() {
            addCriterion("empPhone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpphoneEqualTo(String value) {
            addCriterion("empPhone =", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotEqualTo(String value) {
            addCriterion("empPhone <>", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneGreaterThan(String value) {
            addCriterion("empPhone >", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneGreaterThanOrEqualTo(String value) {
            addCriterion("empPhone >=", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLessThan(String value) {
            addCriterion("empPhone <", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLessThanOrEqualTo(String value) {
            addCriterion("empPhone <=", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneLike(String value) {
            addCriterion("empPhone like", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotLike(String value) {
            addCriterion("empPhone not like", value, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneIn(List<String> values) {
            addCriterion("empPhone in", values, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotIn(List<String> values) {
            addCriterion("empPhone not in", values, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneBetween(String value1, String value2) {
            addCriterion("empPhone between", value1, value2, "empphone");
            return (Criteria) this;
        }

        public Criteria andEmpphoneNotBetween(String value1, String value2) {
            addCriterion("empPhone not between", value1, value2, "empphone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIsNull() {
            addCriterion("payPassword is null");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIsNotNull() {
            addCriterion("payPassword is not null");
            return (Criteria) this;
        }

        public Criteria andPaypasswordEqualTo(String value) {
            addCriterion("payPassword =", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotEqualTo(String value) {
            addCriterion("payPassword <>", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordGreaterThan(String value) {
            addCriterion("payPassword >", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordGreaterThanOrEqualTo(String value) {
            addCriterion("payPassword >=", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLessThan(String value) {
            addCriterion("payPassword <", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLessThanOrEqualTo(String value) {
            addCriterion("payPassword <=", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordLike(String value) {
            addCriterion("payPassword like", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotLike(String value) {
            addCriterion("payPassword not like", value, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordIn(List<String> values) {
            addCriterion("payPassword in", values, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotIn(List<String> values) {
            addCriterion("payPassword not in", values, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordBetween(String value1, String value2) {
            addCriterion("payPassword between", value1, value2, "paypassword");
            return (Criteria) this;
        }

        public Criteria andPaypasswordNotBetween(String value1, String value2) {
            addCriterion("payPassword not between", value1, value2, "paypassword");
            return (Criteria) this;
        }

        public Criteria andEmpidcardIsNull() {
            addCriterion("empIdcard is null");
            return (Criteria) this;
        }

        public Criteria andEmpidcardIsNotNull() {
            addCriterion("empIdcard is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidcardEqualTo(String value) {
            addCriterion("empIdcard =", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardNotEqualTo(String value) {
            addCriterion("empIdcard <>", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardGreaterThan(String value) {
            addCriterion("empIdcard >", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardGreaterThanOrEqualTo(String value) {
            addCriterion("empIdcard >=", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardLessThan(String value) {
            addCriterion("empIdcard <", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardLessThanOrEqualTo(String value) {
            addCriterion("empIdcard <=", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardLike(String value) {
            addCriterion("empIdcard like", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardNotLike(String value) {
            addCriterion("empIdcard not like", value, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardIn(List<String> values) {
            addCriterion("empIdcard in", values, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardNotIn(List<String> values) {
            addCriterion("empIdcard not in", values, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardBetween(String value1, String value2) {
            addCriterion("empIdcard between", value1, value2, "empidcard");
            return (Criteria) this;
        }

        public Criteria andEmpidcardNotBetween(String value1, String value2) {
            addCriterion("empIdcard not between", value1, value2, "empidcard");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationIsNull() {
            addCriterion("IfAuthentication is null");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationIsNotNull() {
            addCriterion("IfAuthentication is not null");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationEqualTo(String value) {
            addCriterion("IfAuthentication =", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationNotEqualTo(String value) {
            addCriterion("IfAuthentication <>", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationGreaterThan(String value) {
            addCriterion("IfAuthentication >", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationGreaterThanOrEqualTo(String value) {
            addCriterion("IfAuthentication >=", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationLessThan(String value) {
            addCriterion("IfAuthentication <", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationLessThanOrEqualTo(String value) {
            addCriterion("IfAuthentication <=", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationLike(String value) {
            addCriterion("IfAuthentication like", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationNotLike(String value) {
            addCriterion("IfAuthentication not like", value, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationIn(List<String> values) {
            addCriterion("IfAuthentication in", values, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationNotIn(List<String> values) {
            addCriterion("IfAuthentication not in", values, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationBetween(String value1, String value2) {
            addCriterion("IfAuthentication between", value1, value2, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andIfauthenticationNotBetween(String value1, String value2) {
            addCriterion("IfAuthentication not between", value1, value2, "ifauthentication");
            return (Criteria) this;
        }

        public Criteria andSharerateIsNull() {
            addCriterion("shareRate is null");
            return (Criteria) this;
        }

        public Criteria andSharerateIsNotNull() {
            addCriterion("shareRate is not null");
            return (Criteria) this;
        }

        public Criteria andSharerateEqualTo(Double value) {
            addCriterion("shareRate =", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateNotEqualTo(Double value) {
            addCriterion("shareRate <>", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateGreaterThan(Double value) {
            addCriterion("shareRate >", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateGreaterThanOrEqualTo(Double value) {
            addCriterion("shareRate >=", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateLessThan(Double value) {
            addCriterion("shareRate <", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateLessThanOrEqualTo(Double value) {
            addCriterion("shareRate <=", value, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateIn(List<Double> values) {
            addCriterion("shareRate in", values, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateNotIn(List<Double> values) {
            addCriterion("shareRate not in", values, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateBetween(Double value1, Double value2) {
            addCriterion("shareRate between", value1, value2, "sharerate");
            return (Criteria) this;
        }

        public Criteria andSharerateNotBetween(Double value1, Double value2) {
            addCriterion("shareRate not between", value1, value2, "sharerate");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIsNull() {
            addCriterion("accountBalance is null");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIsNotNull() {
            addCriterion("accountBalance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceEqualTo(Double value) {
            addCriterion("accountBalance =", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotEqualTo(Double value) {
            addCriterion("accountBalance <>", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceGreaterThan(Double value) {
            addCriterion("accountBalance >", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("accountBalance >=", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceLessThan(Double value) {
            addCriterion("accountBalance <", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceLessThanOrEqualTo(Double value) {
            addCriterion("accountBalance <=", value, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceIn(List<Double> values) {
            addCriterion("accountBalance in", values, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotIn(List<Double> values) {
            addCriterion("accountBalance not in", values, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceBetween(Double value1, Double value2) {
            addCriterion("accountBalance between", value1, value2, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andAccountbalanceNotBetween(Double value1, Double value2) {
            addCriterion("accountBalance not between", value1, value2, "accountbalance");
            return (Criteria) this;
        }

        public Criteria andZfbaccountIsNull() {
            addCriterion("zfbaccount is null");
            return (Criteria) this;
        }

        public Criteria andZfbaccountIsNotNull() {
            addCriterion("zfbaccount is not null");
            return (Criteria) this;
        }

        public Criteria andZfbaccountEqualTo(String value) {
            addCriterion("zfbaccount =", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountNotEqualTo(String value) {
            addCriterion("zfbaccount <>", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountGreaterThan(String value) {
            addCriterion("zfbaccount >", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountGreaterThanOrEqualTo(String value) {
            addCriterion("zfbaccount >=", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountLessThan(String value) {
            addCriterion("zfbaccount <", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountLessThanOrEqualTo(String value) {
            addCriterion("zfbaccount <=", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountLike(String value) {
            addCriterion("zfbaccount like", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountNotLike(String value) {
            addCriterion("zfbaccount not like", value, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountIn(List<String> values) {
            addCriterion("zfbaccount in", values, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountNotIn(List<String> values) {
            addCriterion("zfbaccount not in", values, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountBetween(String value1, String value2) {
            addCriterion("zfbaccount between", value1, value2, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andZfbaccountNotBetween(String value1, String value2) {
            addCriterion("zfbaccount not between", value1, value2, "zfbaccount");
            return (Criteria) this;
        }

        public Criteria andWxopendidIsNull() {
            addCriterion("wxopendid is null");
            return (Criteria) this;
        }

        public Criteria andWxopendidIsNotNull() {
            addCriterion("wxopendid is not null");
            return (Criteria) this;
        }

        public Criteria andWxopendidEqualTo(String value) {
            addCriterion("wxopendid =", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidNotEqualTo(String value) {
            addCriterion("wxopendid <>", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidGreaterThan(String value) {
            addCriterion("wxopendid >", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidGreaterThanOrEqualTo(String value) {
            addCriterion("wxopendid >=", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidLessThan(String value) {
            addCriterion("wxopendid <", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidLessThanOrEqualTo(String value) {
            addCriterion("wxopendid <=", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidLike(String value) {
            addCriterion("wxopendid like", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidNotLike(String value) {
            addCriterion("wxopendid not like", value, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidIn(List<String> values) {
            addCriterion("wxopendid in", values, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidNotIn(List<String> values) {
            addCriterion("wxopendid not in", values, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidBetween(String value1, String value2) {
            addCriterion("wxopendid between", value1, value2, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andWxopendidNotBetween(String value1, String value2) {
            addCriterion("wxopendid not between", value1, value2, "wxopendid");
            return (Criteria) this;
        }

        public Criteria andSharemaxIsNull() {
            addCriterion("shareMax is null");
            return (Criteria) this;
        }

        public Criteria andSharemaxIsNotNull() {
            addCriterion("shareMax is not null");
            return (Criteria) this;
        }

        public Criteria andSharemaxEqualTo(Double value) {
            addCriterion("shareMax =", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxNotEqualTo(Double value) {
            addCriterion("shareMax <>", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxGreaterThan(Double value) {
            addCriterion("shareMax >", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxGreaterThanOrEqualTo(Double value) {
            addCriterion("shareMax >=", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxLessThan(Double value) {
            addCriterion("shareMax <", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxLessThanOrEqualTo(Double value) {
            addCriterion("shareMax <=", value, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxIn(List<Double> values) {
            addCriterion("shareMax in", values, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxNotIn(List<Double> values) {
            addCriterion("shareMax not in", values, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxBetween(Double value1, Double value2) {
            addCriterion("shareMax between", value1, value2, "sharemax");
            return (Criteria) this;
        }

        public Criteria andSharemaxNotBetween(Double value1, Double value2) {
            addCriterion("shareMax not between", value1, value2, "sharemax");
            return (Criteria) this;
        }

        public Criteria andIfdisabledIsNull() {
            addCriterion("IfDisabled is null");
            return (Criteria) this;
        }

        public Criteria andIfdisabledIsNotNull() {
            addCriterion("IfDisabled is not null");
            return (Criteria) this;
        }

        public Criteria andIfdisabledEqualTo(String value) {
            addCriterion("IfDisabled =", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledNotEqualTo(String value) {
            addCriterion("IfDisabled <>", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledGreaterThan(String value) {
            addCriterion("IfDisabled >", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledGreaterThanOrEqualTo(String value) {
            addCriterion("IfDisabled >=", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledLessThan(String value) {
            addCriterion("IfDisabled <", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledLessThanOrEqualTo(String value) {
            addCriterion("IfDisabled <=", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledLike(String value) {
            addCriterion("IfDisabled like", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledNotLike(String value) {
            addCriterion("IfDisabled not like", value, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledIn(List<String> values) {
            addCriterion("IfDisabled in", values, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledNotIn(List<String> values) {
            addCriterion("IfDisabled not in", values, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledBetween(String value1, String value2) {
            addCriterion("IfDisabled between", value1, value2, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdisabledNotBetween(String value1, String value2) {
            addCriterion("IfDisabled not between", value1, value2, "ifdisabled");
            return (Criteria) this;
        }

        public Criteria andIfdeleteIsNull() {
            addCriterion("IfDelete is null");
            return (Criteria) this;
        }

        public Criteria andIfdeleteIsNotNull() {
            addCriterion("IfDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIfdeleteEqualTo(String value) {
            addCriterion("IfDelete =", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteNotEqualTo(String value) {
            addCriterion("IfDelete <>", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteGreaterThan(String value) {
            addCriterion("IfDelete >", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("IfDelete >=", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteLessThan(String value) {
            addCriterion("IfDelete <", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteLessThanOrEqualTo(String value) {
            addCriterion("IfDelete <=", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteLike(String value) {
            addCriterion("IfDelete like", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteNotLike(String value) {
            addCriterion("IfDelete not like", value, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteIn(List<String> values) {
            addCriterion("IfDelete in", values, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteNotIn(List<String> values) {
            addCriterion("IfDelete not in", values, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteBetween(String value1, String value2) {
            addCriterion("IfDelete between", value1, value2, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andIfdeleteNotBetween(String value1, String value2) {
            addCriterion("IfDelete not between", value1, value2, "ifdelete");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidIsNull() {
            addCriterion("empOrganizationId is null");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidIsNotNull() {
            addCriterion("empOrganizationId is not null");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidEqualTo(String value) {
            addCriterion("empOrganizationId =", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidNotEqualTo(String value) {
            addCriterion("empOrganizationId <>", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidGreaterThan(String value) {
            addCriterion("empOrganizationId >", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidGreaterThanOrEqualTo(String value) {
            addCriterion("empOrganizationId >=", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidLessThan(String value) {
            addCriterion("empOrganizationId <", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidLessThanOrEqualTo(String value) {
            addCriterion("empOrganizationId <=", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidLike(String value) {
            addCriterion("empOrganizationId like", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidNotLike(String value) {
            addCriterion("empOrganizationId not like", value, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidIn(List<String> values) {
            addCriterion("empOrganizationId in", values, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidNotIn(List<String> values) {
            addCriterion("empOrganizationId not in", values, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidBetween(String value1, String value2) {
            addCriterion("empOrganizationId between", value1, value2, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmporganizationidNotBetween(String value1, String value2) {
            addCriterion("empOrganizationId not between", value1, value2, "emporganizationid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidIsNull() {
            addCriterion("empIcategoryId is null");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidIsNotNull() {
            addCriterion("empIcategoryId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidEqualTo(String value) {
            addCriterion("empIcategoryId =", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidNotEqualTo(String value) {
            addCriterion("empIcategoryId <>", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidGreaterThan(String value) {
            addCriterion("empIcategoryId >", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidGreaterThanOrEqualTo(String value) {
            addCriterion("empIcategoryId >=", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidLessThan(String value) {
            addCriterion("empIcategoryId <", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidLessThanOrEqualTo(String value) {
            addCriterion("empIcategoryId <=", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidLike(String value) {
            addCriterion("empIcategoryId like", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidNotLike(String value) {
            addCriterion("empIcategoryId not like", value, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidIn(List<String> values) {
            addCriterion("empIcategoryId in", values, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidNotIn(List<String> values) {
            addCriterion("empIcategoryId not in", values, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidBetween(String value1, String value2) {
            addCriterion("empIcategoryId between", value1, value2, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andEmpicategoryidNotBetween(String value1, String value2) {
            addCriterion("empIcategoryId not between", value1, value2, "empicategoryid");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNull() {
            addCriterion("areaId is null");
            return (Criteria) this;
        }

        public Criteria andAreaidIsNotNull() {
            addCriterion("areaId is not null");
            return (Criteria) this;
        }

        public Criteria andAreaidEqualTo(String value) {
            addCriterion("areaId =", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotEqualTo(String value) {
            addCriterion("areaId <>", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThan(String value) {
            addCriterion("areaId >", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidGreaterThanOrEqualTo(String value) {
            addCriterion("areaId >=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThan(String value) {
            addCriterion("areaId <", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLessThanOrEqualTo(String value) {
            addCriterion("areaId <=", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidLike(String value) {
            addCriterion("areaId like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotLike(String value) {
            addCriterion("areaId not like", value, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidIn(List<String> values) {
            addCriterion("areaId in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotIn(List<String> values) {
            addCriterion("areaId not in", values, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidBetween(String value1, String value2) {
            addCriterion("areaId between", value1, value2, "areaid");
            return (Criteria) this;
        }

        public Criteria andAreaidNotBetween(String value1, String value2) {
            addCriterion("areaId not between", value1, value2, "areaid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}