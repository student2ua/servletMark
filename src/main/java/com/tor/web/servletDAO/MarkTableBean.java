package com.tor.web.servletDAO;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

/**
 * User: tor
 * Date: 28.08.19
 * Time: 19:47
 *
 * @RequestScoped Используется по умолчанию. При каждом HTTP запросе создается новый компонент. Если форма содержит данные, которые отправляются на сервер для обработки, то компонент будет создаваться 2 раза. Первоначально компонент создаётся при открытии страницы, с которой компонент связан. Повторно компонент создаётся по отправке формы.
 * @NoneScoped Бин живёт так долго, как EL оценка. Созадётся в момент EL оценки и уничтожается сразу после неё.
 * @ViewScoped Бин живёт до тех пор, пока пользователь взаимодействует с JSF представлением в браузере или окне. Создаётся в момент HTTP – запроса и уничтожается после того, как пользователь переходит к другому JSF представлению (например, на другую страницу).
 * @SessionScoped Бин живет до тех пор, пока существует HTTP сессия. Созадётся в момент первого HTTP – запроса, который вводит данный бин в сессию и уничтожается в момент, когда сессия становится не валидной.
 * @ApplicationScoped Бин живет, пока живёт приложение. СОзадётся в момент первого HTTP – запроса, который вводит данный бин в приложение (или когда приложение запускается, в случае “eager = true“) и уничтодается в момент прекращения завершения работы приложения.
 * @CustomScoped Бин живёт, пока входит в указанную Map.
 * http://java-online.ru/jsf-lifecycle.xhtml
 * @ManagedProperty(value = "#{markTable}") ?
 */
@ManagedBean(name = "markTable")
@ViewScoped
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin", "TEACHER_MARK"}))
/*@ServletSecurity(httpMethodConstraints={
        @HttpMethodConstraint("GET"),
       @HttpMethodConstraint(value = "POST", rolesAllowed = "TEACHER_MARK", transportGuarantee = TransportGuarantee.CONFIDENTIAL)) требует защищенного соединения*/
public class MarkTableBean {
    @PostConstruct
    public void init() {
//   предзагрузка данных
        // Get the current servlet request from the facesContext
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        Map<String,String> params =  ctx.getExternalContext().getRequestParameterMap();
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        principal.getName();
        final Integer empId = (Integer) request.getAttribute(Params.EMPLOYEE_ID.toString());
        //для формирования таблици нужен заполненный
    }

    private static String colABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * @param column 0 based,  < 5*26
     */
    private String getColumnChar(int column) {
        assert column >= 0;
//       colABC.charAt(column%colABC.length())
        StringBuilder builder = new StringBuilder();
        switch (column % colABC.length()) {
            case 1:
                builder.append("A").append(colABC.charAt(column - colABC.length()));
                break;
            case 2:
                builder.append("B").append(colABC.charAt(column - 2 * colABC.length()));
                break;
            case 3:
                builder.append("C").append(colABC.charAt(column - 3 * colABC.length()));
                break;
            case 4:
                builder.append("D").append(colABC.charAt(column - 4 * colABC.length()));
                break;
            default:
                builder.append(colABC.charAt(column));

        }
        return builder.toString();
    }

    /**
     * @see #getColumnChar(int)
     */
    public String getTableData() {
        return "[\n" +
                "    {\n" +
                "        A: 'Аванесян Христина Вячеславівна',\n" +
                "        B: 'HH',\n" +
                "        C: 1,\n" +
                "        D: 1,\n" +
                "        E: 'JPY',\n" +
                "        F: 1,\n" +
                "        G: 1,\n" +
                "        H: 'JPY',\n" +
                "        I: 1,\n" +
                "        J: 2,\n" +
                "        K: 'JPY',\n" +
                "        L: 1,\n" +
                "        M: 1,\n" +
                "        N: 'JPY',\n" +
                "        O: 1,\n" +
                "        P: 2,\n" +
                "        Q: 'JPY',\n" +
                "        R: 1,\n" +
                "        S: 1,\n" +
                "        T: 'JPY',\n" +
                "        U: 1,\n" +
                "        V: 2,\n" +
                "        W: 'JPY',\n" +
                "        X: 1,\n" +
                "        Y: 1,\n" +
                "        Z: 'JPY',\n" +
                "        AA: 1,\n" +
                "        AB: 1,\n" +
                "        AC: 'JPY',\n" +
                "        AD: 1,\n" +
                "        AE: 2,\n" +
                "        AF: 'JPY',\n" +
                "        AG: 1,\n" +
                "        AH: 1,\n" +
                "        AI: 'JPY',\n" +
                "        AJ: 2.5,\n" +
                "        AK: 1,\n" +
                "        AL: 'JPY',\n" +
                "        AM: 1,\n" +
                "        AN: 1.7,\n" +
                "        AO: 'JPY',\n" +
                "        AP: 1,\n" +
                "        AQ: 1,\n" +
                "        AR: 'JPY',\n" +
                "        AS: 1,\n" +
                "        AT: 1,\n" +
                "        AU: 'CAD',\n" +
                "        AV: 1,\n" +
                "        AW: 'CAD',\n" +
                "        AX: 12,\n" +
                "        sas49: 0,\n" +
                "        count50: 11,\n" +
                "        sum51: '=C1+D1+F1+G1+I1+J1+L1+M1+O1+P1+R1+S1+U1+V1+X1+Y1+AA1+AB1+AD1+AE1+AG1+AH1+AJ1+AK1+AM1+AN1+AP1+AQ1+AS1+AT1+AV1+AX1'\n" +
                "\n" +
                "    },\n" +
                "    { A: 'Боброва Яна Янівна',\n" +
                "        B: '',\n" +
                "        C: 0.5,\n" +
                "        D: 1,\n" +
                "        E: 'JPY',\n" +
                "        F: 1,\n" +
                "        G: 1,\n" +
                "        H: 'JPY',\n" +
                "        I: 1,\n" +
                "        J: 2,\n" +
                "        K: 'JPY',\n" +
                "        L: 1,\n" +
                "        M: 1,\n" +
                "        N: 'JPY',\n" +
                "        O: 1,\n" +
                "        P: 2,\n" +
                "        Q: 'JPY',\n" +
                "        R: 1,\n" +
                "        S: 1,\n" +
                "        T: 'JPY',\n" +
                "        U: 1,\n" +
                "        V: 2,\n" +
                "        W: 'JPY',\n" +
                "        X: 1,\n" +
                "        Y: 1,\n" +
                "        Z: 'JPY',\n" +
                "        AA: 1,\n" +
                "        AB: 1,\n" +
                "        AC: 'JPY',\n" +
                "        AD: 1,\n" +
                "        AE: 2,\n" +
                "        AF: 'JPY',\n" +
                "        AG: 1,\n" +
                "        AH: 1,\n" +
                "        AI: 'CAD',\n" +
                "        AJ: 2.5,\n" +
                "        AK: 1,\n" +
                "        AL: 'CAD',\n" +
                "        AM: 1,\n" +
                "        AN: 1.7,\n" +
                "        AO: 'CAD',\n" +
                "        AP: 1,\n" +
                "        AQ: 1,\n" +
                "        AR: 'CAD',\n" +
                "        AS: 1,\n" +
                "        AT: 2,\n" +
                "        AU: 'CAD',\n" +
                "        AV: 1,\n" +
                "        AW: 'CAD',\n" +
                "        AX: 13,\n" +
                "\n" +
                "        sasl49: 'count(b2,e2)',\n" +
                "        count50: 11,\n" +
                "        sum51: '=C2+D2+F2+G2+I2+J2+L2+M2+O2+P2+R2+S2+U2+V2+X2+Y2+AA2+AB2+AD2+AE2+AG2+AH2+AJ2+AK2+AM2+AN2+AP2+AQ2+AS2+AT2+AV2+AX2'\n" +
                "    }\n" +
                "]";
    }

    public String getTableHeader() {
        return "[\n" +
                "        ['studentFIO',\n" +
                "            {label: '15.03 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '22.03<br> п.№ 2', colspan: 3},\n" +
                "            {label: '29.03<br> п.№ 2', colspan: 3},\n" +
                "            {label: '05.04<br> п.№ 2', colspan: 3},\n" +
                "            {label: '12.04 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '19.04 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '26.04<br> п.№ 2', colspan: 3},\n" +
                "            {label: '03.05 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '10.05<br> п.№ 2', colspan: 3},\n" +
                "            {label: '17.05 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '24.05 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '31.05 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '07.06<br> п.№ 2', colspan: 3},\n" +
                "            {label: '14.06 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '21.06 <br>п.№ 2', colspan: 3},\n" +
                "            {label: '24.06<br> п.№ 1', colspan: 2},\n" +
                "            {label: '24.06 <br>п.№ 2', colspan: 2},\n" +
                "            'Кол-во пропусков',\n" +
                "            'Накопительный',\n" +
                "            'SUM'\n" +
                "        ],\n" +
                "        ['', \"Был\",\n" +
                "            \"ІндОпитув\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"ФронтОпит\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"ПисьмовіКР\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"ФронтОпит\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"ПисьмовіКР \",\n" +
                "\n" +
                "            \"Был\",\n" +
                "            \"ІндОпитув \",\n" +
                "            \"АктРобПар \",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар \",\n" +
                "            \"ПисьмовіКР\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар \",\n" +
                "            \"ФронтОпит\",\n" +
                "            \"Был\",\n" +
                "            \"ІндОпитув \",\n" +
                "            \"АктРобПар \",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар \",\n" +
                "            \"ПисьмовіКР \",\n" +
                "\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар \",\n" +
                "            \"ФронтОпит \",\n" +
                "            \"Был\",\n" +
                "            \"ТворЗавдан \",\n" +
                "            \"АктРобПар\",\n" +
                "            \"Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"ПисьмовіКР\",\n" +
                "            \" Был\",\n" +
                "            \" ІндОпитув\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"Был \",\n" +
                "            \"АктРобПар \",\n" +
                "            \"ФронтОпит \",\n" +
                "\n" +
                "            \" Был\",\n" +
                "            \"АктРобПар\",\n" +
                "            \"Был\",\n" +
                "            \"Доповідь\",\n" +
                "            '']\n" +
                "    ]";
    }

    public String getTableHeaderType() {
        return "[\n" +
                "        {data: 'A', type: 'text'/*, width: 240*/, readOnly: true},\n" +
                "\n" +
                "        {data: 'B', type: 'dropdown', source: ['', 'H -', 'HH', '-H']},\n" +
                "        {data: 'C', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'D', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'E', renderer: flagRenderer },\n" +
                "        {data: 'F', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'G', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'H', renderer: flagRenderer },\n" +
                "        {data: 'I', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'J', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'K', renderer: flagRenderer },\n" +
                "        {data: 'L', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'M', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'N', renderer: flagRenderer },\n" +
                "        {data: 'O', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'P', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "\n" +
                "        {data: 'Q', renderer: flagRenderer },\n" +
                "        {data: 'R', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'S', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'T', renderer: flagRenderer },\n" +
                "        {data: 'U', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'V', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'W', renderer: flagRenderer },\n" +
                "        {data: 'X', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'Y', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'Z', renderer: flagRenderer },\n" +
                "        {data: 'AA', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AB', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AC', renderer: flagRenderer },\n" +
                "        {data: 'AD', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AE', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "\n" +
                "        {data: 'AF', renderer: flagRenderer },\n" +
                "        {data: 'AG', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AH', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AI', renderer: flagRenderer },\n" +
                "        {data: 'AJ', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AK', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AL', renderer: flagRenderer },\n" +
                "        {data: 'AM', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AN', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AO', renderer: flagRenderer },\n" +
                "        {data: 'AP', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AQ', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AR', renderer: flagRenderer },\n" +
                "        {data: 'AS', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AT', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "\n" +
                "        {data: 'AU', renderer: flagRenderer },\n" +
                "        {data: 'AV', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'AW', renderer: flagRenderer },\n" +
                "        {data: 'AX', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "\n" +
                "        {data: 'sas49', type: 'numeric', numericFormat: {pattern: '0.00'}},\n" +
                "        {data: 'count50', type: 'numeric', numericFormat: {pattern: '0'}},\n" +
                "        {data: 'sum51', type: 'numeric', numericFormat: {pattern: '0.00'}}\n" +
                "\n" +
                "    ]";
    }
}
