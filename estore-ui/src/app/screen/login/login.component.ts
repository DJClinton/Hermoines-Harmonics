import { Component } from '@angular/core';
import { AuthorizationService } from '../../service/authorization.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  constructor(private authorizationService: AuthorizationService) {}

  login(email: string, password: string): void {
    console.log(email, password);

    this.authorizationService.login(email, password);
  }
}
