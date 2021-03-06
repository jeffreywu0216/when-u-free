import { Injectable } from '@angular/core';
import { User } from '../domain/user'
import { Observable } from 'rxjs/Observable'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from '../message.service';


@Injectable()
export class UserService {
	userUrl = 'http://localhost:8080/user';
	headers = new HttpHeaders()
		.set('X-Requested-With', 'XMLHttpRequest'); // to suppress 401 browser popup
	options = {headers: this.headers, withCredentials: true};


	constructor( private http: HttpClient,
			   private messageService: MessageService) { }

	getUser(): Observable<User> {
		return this.http.get<User>(this.userUrl, this.options)
	}

	updateUser( user: User): Observable<User> {
		return this.http.post<User>('http://localhost:8080//updateuser', user, this.options);
	}

	deleteUser( user: User): Observable<User> {
		return this.http.post<User>(this.userUrl, user, this.options);
	}
}
