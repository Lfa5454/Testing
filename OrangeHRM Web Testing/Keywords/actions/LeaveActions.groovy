package actions

import pages.LeavePage
import helpers.LeaveHelpers
import com.kms.katalon.core.util.KeywordUtil

class LeaveActions {

    LeavePage page = new LeavePage()
    LeaveHelpers helper = new LeaveHelpers()

    def performAction(String actionType, Map params = [:]) {

        if (params.containsKey('firstName') && params.containsKey('lastName')) {
            params['name'] = params['firstName'] + " " + params['lastName']
        }

        switch(actionType.toLowerCase()) {

            case "openleave":
                page.openLeaveMenu()
                break

            case "openassignleave":
                page.openAssignLeave()
                break

            case "selectemployee":
                page.typeEmployee(params['name'])
                helper.selectDropdownTwice(page.dropdownArrow)
                break

            case "search":
                page.clickSearch()
                break

            case "setdates":
                helper.setDate(page.fromDateInput, params['from'])
                helper.setDate(page.toDateInput, params['to'])
                break

            case "assignleave":
                page.clickAssign()
                break

            case "confirm":
                page.clickOk()
                break

            case "openperformance":
                page.click(page.menuPerformance)
                break

            case "selectresult":
                page.selectResultRow()
                break

            default:
                KeywordUtil.markFailed("Unsupported action: " + actionType)
        }
    }
}