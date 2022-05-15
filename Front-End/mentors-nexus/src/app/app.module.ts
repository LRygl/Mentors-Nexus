import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationGuard } from './guard/authentication.guard';
import { AuthenticationService } from './service/authentication.service';
import { UserService } from './service/user.service';

import { FormsModule } from '@angular/forms';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { LoginComponent } from './component/login/login.component';
import { UserComponent } from './component/user/user/user.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    AuthenticationService,
    UserService,
    AuthenticationGuard,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
