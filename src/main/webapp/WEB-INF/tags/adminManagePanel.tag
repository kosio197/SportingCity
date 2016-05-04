<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="manage" %>

         <a href="/logout"><button>* Logout *</button></a>
         <br /><br />
         <a href="/home"><button>Back to main page</button></a>
         <br /><br />
         <a href="/admin/manage/account"><button>Manage Account</button></a> &nbsp;
         <a href="/admin/manage/club"><button>Manage Club</button></a> &nbsp;
         <a href="/admin/manage/training"><button>Manage Training</button></a> &nbsp;
         <a href="/admin/manage/competition"><button>Manage Competition</button></a> &nbsp;
         <a href="/admin/manage/seminar"><button>Manage Seminar</button></a>
         <br /> <br />

         <h3>manage ${manage} </h3>