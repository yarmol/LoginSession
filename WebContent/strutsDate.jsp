<%-- <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head />
  </head>
  <body>
    <s:form id="form" theme="xhtml">
      <sj:datepicker id="date0" label="Select a Date" />
      <sj:datepicker value="%{dateValue}" id="date1" name="date1" label="Date Value from Action" />
      <sj:datepicker id="date2" name="nameValue" label="Date Value by Name" />
      <sj:datepicker value="today" id="date3" name="date3" displayFormat="dd.mm.yy" label="Today" />
      <sj:datepicker value="yesterday" id="date4" name="date4" displayFormat="mm/dd/yy" label="Yesterday" />
      <sj:datepicker value="tomorrow" id="date5" name="date5" displayFormat="DD, d MM yy" label="Tomorrow" />
      <sj:datepicker value="2004-08-14" id="date6" name="date6" displayFormat="d M, yy" label="String Value" />
    </s:form>
  </body>
</html>  --%>