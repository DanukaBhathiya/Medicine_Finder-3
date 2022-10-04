import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { UserPageComponent } from './user-page/user-page.component';

const routes: Routes = [
  {path:'home',component:HomePageComponent},
  {path:'admin',component:AdminPageComponent},
  {path:'user',component:UserPageComponent},
  {path:'login',component:LoginPageComponent},
  {path:'signup',component:RegistrationPageComponent},
  {path:'forbidden',component:ForbiddenComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
