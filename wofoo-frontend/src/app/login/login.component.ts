import { User } from './../../../class/user';
import { UserService } from './../../../service/user.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  private username!: string;
  private password!: string;

  private theUser: User = new User();
  private invalidLogin: boolean = false;
  private alert: boolean = false;

  constructor(private userService: UserService) { }

  public login(username: string) {
    this.userService.getUser(username)
      .subscribe({
        next: (response) => {
          if (response != null || response != undefined) {
            this.theUser = response;
            this.validation();
          } else {
            this.alert = true;
          }
        }
      });
  }
}

public validation() {

}

