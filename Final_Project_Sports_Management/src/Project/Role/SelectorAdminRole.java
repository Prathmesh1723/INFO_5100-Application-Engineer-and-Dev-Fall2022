/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Role;

import Project.MainSystem;
import Project.Enterprise.Enterprise;
import Project.Organization.Organization;
import Project.UserAccount.UserAccount;
import UI.SelectorEnterprise.SelectorAdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author vidis
 */
public class SelectorAdminRole extends Role{
    //overriding main panel with fireman admin work area whenever fireman admin role is called
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount account,Organization organization,Enterprise enterprise,MainSystem system){
        return new SelectorAdminWorkArea(userProcessContainer,enterprise,system);
    }   
        @Override
        public String toString()
{
   return Role.RoleType.SelectorAdminRole.getValue();
}

}
