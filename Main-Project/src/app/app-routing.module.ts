import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './Components/registration/registration.component';
import { LoginComponent } from './Components/login/login.component';
import { WelcomeComponent } from './Components/welcome/welcome.component';
import { ForgotpasswordComponent } from './Components/forgotpassword/forgotpassword.component';
import { ResetpasswordComponent } from './Components/resetpassword/resetpassword.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';

const routes: Routes = [
  {path:'',component:WelcomeComponent},
  {path:"register",component:RegistrationComponent},
  {path: "login",component:LoginComponent},
  {path:"welcome",component:WelcomeComponent},
  {path:"forgotpassword",component:ForgotpasswordComponent},
  {path:"resetpassword",component:ResetpasswordComponent},
  { path:'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
