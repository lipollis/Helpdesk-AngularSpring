# Frontend


## Passos de criação do projeto:
#### Instalação do Angular
```typescript
npm install -g @angular/cli
```
#### Criação do projeto
```typescript
ng new frontend
```
#### Para 'rodar' o projeto
```typescript
ng serve
```
### Configurações
#### Em tsconfig.json, alterar comando para flexibilizar classes string e date
```json
"strict": false,
```
#### Em angular.json, alterar as configuração, pois o template e o css não estarão inline:
```json
"schematics": {
        "@schematics/angular:component": {
          "inlineTemplate": false,
          "inlineStyle": false,
          "skipTests": true
        },
        "@schematics/angular:class": {
          "skipTests": true
        },
        "@schematics/angular:directive": {
          "skipTests": true
        },
        "@schematics/angular:guard": {
          "skipTests": true
        },
        "@schematics/angular:interceptor": {
          "skipTests": true
        },
        "@schematics/angular:pipe": {
          "skipTests": true
        },
        "@schematics/angular:service": {
          "skipTests": true
        },
        "@schematics/angular:application": {
          "strict": true
        }
      },
```
### Bibliotecas
#### Instalando a biblioteca Angular Material - Em CSS e sem tema sugerido
```typescript
ng add @angular/material
```
#### Instalando a biblioteca Bootstrap
```typescript
ng add @ng-bootstrap/ng-bootstrap
```
#### Instalando o toastr de forma global
```typescript
npm i ngx-toastr --save
```
#### Instalação de máscara
```typescript
npm i ngx-mask --save
```
#### Instalação do JWT
```typescript
npm i @auth0/angular-jwt --save
```

### Criando componentes
```typescript
ng g c components/nav
ng g c components/home
ng g c components/header
ng g c components/tecnico/tecnico-list
ng g c components/tecnico/tecnico-create
ng g c components/tecnico/tecnico-update
ng g c components/tecnico/tecnico-delete
ng g c components/login
ng g c components/cliente/cliente-list
ng g c components/cliente/cliente-create
ng g c components/cliente/cliente-update
ng g c components/cliente/cliente-delete
ng g c components/chamado/chamado-list
ng g c components/chamado/chamado-create
ng g c components/chamado/chamado-update
ng g c components/chamado/chamado-read
```
#### Serviço para buscar no backend as informações
```typescript
ng g s services/auth
ng g guard auth/auth
ng g s services/tecnico
ng g s services/cliente
ng g s services/chamado
```
### Imports feitos no app.module
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Para trabalhar com formulários no Angular 12
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

// Para realizar requisições HTTP
import { HttpClientModule } from '@angular/common/http';

// Imports para componentes do Angular Material
import { MatSliderModule } from '@angular/material/slider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';

import { ToastrModule } from 'ngx-toastr';
import { NgxMaskModule } from 'ngx-mask';

// Componentes do projeto
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { TecnicoListComponent } from './components/tecnico/tecnico-list/tecnico-list.component';
import { LoginComponent } from './components/login/login.component';
import { TecnicoCreateComponent } from './components/tecnico/tecnico-create/tecnico-create.component';
import { TecnicoUpdateComponent } from './components/tecnico/tecnico-update/tecnico-update.component';
import { TecnicoDeleteComponent } from './components/tecnico/tecnico-delete/tecnico-delete.component';
import { ClienteCreateComponent } from './components/cliente/cliente-create/cliente-create.component';
import { ClienteDeleteComponent } from './components/cliente/cliente-delete/cliente-delete.component';
import { ClienteListComponent } from './components/cliente/cliente-list/cliente-list.component';
import { ClienteUpdateComponent } from './components/cliente/cliente-update/cliente-update.component';
import { ChamadoListComponent } from './components/chamado/chamado-list/chamado-list.component';
import { ChamadoCreateComponent } from './components/chamado/chamado-create/chamado-create.component';
import { ChamadoUpdateComponent } from './components/chamado/chamado-update/chamado-update.component';
import { ChamadoReadComponent } from './components/chamado/chamado-read/chamado-read.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    HeaderComponent,
    TecnicoListComponent,
    LoginComponent,
    TecnicoCreateComponent,
    TecnicoUpdateComponent,
    TecnicoDeleteComponent,
    ClienteCreateComponent,
    ClienteDeleteComponent,
    ClienteListComponent,
    ClienteUpdateComponent,
    ChamadoListComponent,
    ChamadoCreateComponent,
    ChamadoUpdateComponent,
    ChamadoReadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    // Forms
    FormsModule,
    ReactiveFormsModule,
    // Requisições http
    HttpClientModule,
    // Angular Material
    MatSliderModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatRadioModule,
    MatTableModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    ToastrModule.forRoot({
      timeOut: 4000,
      closeButton: true,
      progressBar: true
    }),
    NgxMaskModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
### Rotas definidas
``` typescript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { ChamadoCreateComponent } from './components/chamado/chamado-create/chamado-create.component';
import { ChamadoListComponent } from './components/chamado/chamado-list/chamado-list.component';
import { ChamadoReadComponent } from './components/chamado/chamado-read/chamado-read.component';
import { ChamadoUpdateComponent } from './components/chamado/chamado-update/chamado-update.component';
import { ClienteCreateComponent } from './components/cliente/cliente-create/cliente-create.component';
import { ClienteDeleteComponent } from './components/cliente/cliente-delete/cliente-delete.component';
import { ClienteListComponent } from './components/cliente/cliente-list/cliente-list.component';
import { ClienteUpdateComponent } from './components/cliente/cliente-update/cliente-update.component';
import { TecnicoCreateComponent } from './components/tecnico/tecnico-create/tecnico-create.component';
import { TecnicoDeleteComponent } from './components/tecnico/tecnico-delete/tecnico-delete.component';
import { TecnicoListComponent } from './components/tecnico/tecnico-list/tecnico-list.component';
import { TecnicoUpdateComponent } from './components/tecnico/tecnico-update/tecnico-update.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '', component: NavComponent, canActivate: [AuthGuard], children: [
      { path: 'home', component: HomeComponent },

      { path: 'tecnicos',            component:   TecnicoListComponent },
      { path: 'tecnicos/create',     component: TecnicoCreateComponent },
      { path: 'tecnicos/update/:id', component: TecnicoUpdateComponent },
      { path: 'tecnicos/delete/:id', component: TecnicoDeleteComponent },

      { path: 'clientes',            component:   ClienteListComponent },
      { path: 'clientes/create',     component: ClienteCreateComponent },
      { path: 'clientes/update/:id', component: ClienteUpdateComponent },
      { path: 'clientes/delete/:id', component: ClienteDeleteComponent },

      { path: 'chamados',                       component:     ChamadoListComponent },
      { path: 'chamados/create',                component:   ChamadoCreateComponent },
      { path: 'chamados/update/:id',            component:   ChamadoUpdateComponent },
      { path: 'chamados/read/:id',              component:     ChamadoReadComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

```
### Models
#### Tecnico
```
export interface Tecnico {
   id?:         any;
   nome:     string;
   cpf:      string;
   email:    string;
   senha:    string;
   perfis: string[];
   dataCriacao: any;
 }
```
#### Chamado
```
export interface Chamado {
   id?:                any;
   dataAbertura?:   string;
   dataFechamento?: string;
   prioridade:      string;
   status:          string;
   titulo:          string;
   observacoes:     string;
   tecnico:            any;
   cliente:            any;
   nomeCliente:     string;
   nomeTecnico:     string;
}
```
#### Cliente
```
export interface Cliente {
   id?:         any;
   nome:     string;
   cpf:      string;
   email:    string;
   senha:    string;
   perfis: string[];
   dataCriacao: any;
 }
```
#### Credenciais
```
export interface Credenciais {
   email: string;
   senha: string;
}
```
### NavComponent
#### HTML
```html
    <mat-drawer-container class="container" autosize>
        <mat-drawer #drawer class="sidenav" mode="side">
           <img src="assets/img/side-image.svg" alt="Imagem de navegação">
           <mat-nav-list class="nav-list">
              <a mat-list-item routerLink="home">
                 <i class="material-icons">home</i>
                 Home
              </a>
              <a mat-list-item routerLink="tecnicos">
                 <i class="material-icons">account_circle</i>
                 Técnicos
              </a>
              <a mat-list-item routerLink="clientes">
                 <i class="material-icons">person</i>
                 Clientes
              </a>
              <a mat-list-item routerLink="chamados">
                 <i class="material-icons">support</i>
                 Chamados
              </a>
              <a mat-list-item href="https://github.com/lipollis/Helpdesk-Angular-Spring" target="_blank">
                 <i class="material-icons">code</i>
                 Github
              </a>

              
           </mat-nav-list>
        </mat-drawer>
     
        <div class="sidenav-content">
           <app-header></app-header>
           <button class="menu mat-elevation-z8" (click)="drawer.toggle()" mat-icon-button>
              <mat-icon>menu</mat-icon>
           </button>
           <router-outlet></router-outlet>
        </div>
     
     </mat-drawer-container>
```
#### CSS
```css
.container {
   height: 100%;
}

.sidenav {
   width: 13rem;
   color: white;
   background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(37,97,207,1) 0%, rgba(0,212,255,1) 100%);
}

img {
   width: 100%;
   height: 7rem;
   margin: .8rem auto 1rem auto;
}

.sidenav a {
   color: white;
}

.sidenav i {
   margin-right: .6rem;
}

.menu {
   margin: 1rem 0 0 1rem;
   color: white;
   background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(37,97,207,1) 0%, rgba(0,212,255,1) 100%);
}
```
#### ts
```
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(
    private router: Router,
    private toast: ToastrService) { }

  ngOnInit(): void {
    this.router.navigate(['home'])
  }
}
```
### HomeComponent
#### HTML
``` html
<mat-card class="card mat-elevation-z8">
    <mat-card-header>
      <mat-card-title>Help Desk</mat-card-title>
      <mat-card-subtitle>Dicas de um DEV</mat-card-subtitle>
    </mat-card-header>
    <img mat-card-image src="assets/img/home-image.svg" alt="Image Home Help Desk">
    <mat-card-content>
      <p>
       Olá! Seja bem vindo ao sistema Help Desk desenvolvido por mim no curso Desenvolvedor Full Stack.<br />
       Esse é um sistema para gerenciamento de chamados simulando um simples Help Desk desenvolvido em Angular 12 e
       Spring Boot 2. <br />O sistema está rodando na nuvem sendo o front na Vercel e o back na Heroku.<br />
       O projeto tem como objetivo principal abordar os conceitos de aplicações SPAs, Autenticação e Autorização com
       Tokens JWT e muito mais. O código fonte do projeto pode ser acessado clicando no link Github no menu lateral.
       <br /><br /> 
      </p>
    </mat-card-content>
  </mat-card>
```
#### CSS
```css
.card {
    width: 90%;
    margin: 1rem auto;
    background-color: rgb(235, 235, 235);
 }
 
 img {
    height: 20rem;
 }
```
### HeaderCoponent
#### HTML
```html
<div class="container">
    <h1 class="mat-elevation-z8">Help Desk - Dicas de um DEV</h1>
 </div>
```
#### CSS
```css
.container {
    display: flex;
    align-items: center;
    justify-content: center;
 }
 
 h1 {
    margin-top: 1rem;
    border: 1px solid rgb(161, 159, 159);
    padding: 1rem 10%;
    border-radius: 2rem;
 }
```
### Técnico list
#### HTML
```html
<div class="container">

    <h1>Listando Técnicos</h1>
 
    <button routerLink="create" class="mat-elevation-z8" mat-stroked-button color="primary">Novo técnico</button>
 
    <mat-form-field appearance="standard">
       <mat-label>Filter</mat-label>
       <!-- <input matInput (keyup)="applyFilter($event)" placeholder="Ex. ium" #input> -->
     </mat-form-field>
 
    <div class="mat-elevation-z8">
 
       <table mat-table [dataSource]="dataSource">
 
          <ng-container matColumnDef="id">
             <th mat-header-cell *matHeaderCellDef> ID </th>
             <td mat-cell *matCellDef="let element"> {{element.id}} </td>
          </ng-container>
 
          <ng-container matColumnDef="nome">
             <th mat-header-cell *matHeaderCellDef> Nome </th>
             <td mat-cell *matCellDef="let element"> {{element.nome}} </td>
          </ng-container>
 
          <ng-container matColumnDef="cpf">
             <th mat-header-cell *matHeaderCellDef> CPF </th>
             <td mat-cell *matCellDef="let element"> {{element.cpf}} </td>
          </ng-container>
 
          <ng-container matColumnDef="email">
             <th mat-header-cell *matHeaderCellDef> Email </th>
             <td mat-cell *matCellDef="let element"> {{element.email}} </td>
          </ng-container>
 
          <ng-container matColumnDef="acoes">
             <th mat-header-cell *matHeaderCellDef> Ações </th>
             <td mat-cell *matCellDef="let element">
                <a routerLink="update/{{ element.id }}">
                   <i class="material-icons edit">edit</i>
                </a>
                <a routerLink="delete/{{ element.id }}">
                   <i class="material-icons delete">delete</i>
                </a>
             </td>
          </ng-container>
 
          <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
          <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
       </table>
 
       <mat-paginator [pageSizeOptions]="[5, 2, 10, 20, 50, 100]" showFirstLastButtons></mat-paginator>
    </div>
 
 </div>
```
#### CSS
```css
.container {
    width: 90%;
    margin: auto;
 }
 
 table {
    width: 100%;
 }
 
 mat-form-field {
    width: 100%;
 }
 
 button {
    width: 100%;
 }
 
 h1 {
    width: 100%;
    text-align: center;
    margin-bottom: 2rem;
 }
 
 .edit {
    color: rgb(0, 153, 255);
 }
 
 .delete {
    color: red;
 }
```
#### TS
```typescript
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-list',
  templateUrl: './tecnico-list.component.html',
  styleUrls: ['./tecnico-list.component.css']
})
export class TecnicoListComponent implements OnInit {

  ELEMENT_DATA: Tecnico[] = []

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email', 'acoes'];
  dataSource = new MatTableDataSource<Tecnico>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
  ) { }

  ngOnInit(): void {

  }

}
```
### Login
#### HTML
```html
<div class="container">
   <form class="form mat-elevation-z8">

      <h1>Help Desk - Dicas de um DEV</h1>

      <img src="assets/img/login-image.svg" alt="Help Desk - Dicas de um DEV">

       <mat-form-field class="full-width" appearance="fill">
          <!-- <mat-label>E-mail</mat-label> -->
          <input 
          [formControl]="email"
          required
          [(ngModel)]="creds.email" 
          name="email" 
          matInput 
          placeholder=" ">
          <mat-icon matSuffix>email</mat-icon>
          <mat-hint>E-mail</mat-hint>
       </mat-form-field>
 
       <mat-form-field class="full-width" appearance="fill">
          <!-- <mat-label>Senha</mat-label> -->
          <input 
          [formControl]="senha"
          required
          [(ngModel)]="creds.senha" 
          name="senha" 
          matInput 
          [type]="hide ? 'password' : 'text'"
          placeholder=" ">
          <button mat-icon-button matSuffix (click)="hide = !hide" [attr.aria-label]="'Hide password'" [attr.aria-pressed]="hide">
            <mat-icon>{{hide ? 'visibility_off' : 'visibility'}}</mat-icon>
          </button>
          <mat-hint>Senha</mat-hint>
       </mat-form-field>

      <button (click)="logar()" [disabled]="!validaCampos()" class="full-width mat-elevation-z4" mat-stroked-button color="primary">Login</button>
   </form>

</div>
```
#### CSS
``` css
.container {
   height: 100%;
   background: linear-gradient(180deg, rgba(2,0,36,1) 0%, rgba(37,97,207,1) 0%, rgba(0,212,255,1) 100%);
   display: flex;
   align-items: center;
   justify-content: center;
}

.form {
   width: 30rem;
   margin: auto;
   background-color: rgb(235, 235, 235);
   padding: 4rem 1rem;
   border-radius: 1rem;
}

h1 {
   width: 100%;
   text-align: center;
   
}

img {
   height: 15rem;
   width: 100%;
   margin: 1.5rem auto 1.5rem auto;
}

.full-width {
   width: 100%;
}

button {
   margin-top: 1.5rem;
}

 mat-icon {
    opacity: .6;
 }

 mat-hint{
    color: blue;
    font-size: 0.7rem;
    opacity: .6;
    
 }

 /*input{
    border-bottom: 0.1rem solid blue;
 }*/
```
#### api.config.ts para indicaar o local de hospedagem da aplicação no Heroku
``` json
export const API_CONFIG = {
   baseUrl : 'https://helpdesk-lipollis.herokuapp.com/'
}
```
#### Serviço de autenticação auth.service
``` typescript
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { API_CONFIG } from '../config/api.config';
import { Credenciais } from '../models/credenciais';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  jwtService: JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient) { }

  authenticate(creds: Credenciais) {
    return this.http.post(`${API_CONFIG.baseUrl}/login`, creds, {
      observe: 'response',
      responseType: 'text'
    })
  }

  successfulLogin(authToken: string) {
    localStorage.setItem('token', authToken);
  }

  isAuthenticated() {
    let token = localStorage.getItem('token')
    if(token != null) {
      return !this.jwtService.isTokenExpired(token)
    }
    return false
  }

  logout() {
    localStorage.clear();
  }
}
```
#### auth.guard.ts
```typescript
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
//import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate( route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    let authenticated = this.authService.isAuthenticated();

    if(authenticated) {
      return true;
    } else {
      this.router.navigate(['login']);
      return false
    }
  }
  
}
```
#### login.component.ts
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Credenciais } from 'src/app/models/credenciais';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  creds: Credenciais = {
    email: '',
    senha: ''
  }

  email = new FormControl(null, Validators.email);
  senha = new FormControl(null, Validators.minLength(3));

  constructor(
    private toast: ToastrService,
    private service: AuthService,
    private router: Router) { }

  ngOnInit(): void { }

  logar() {
    this.service.authenticate(this.creds).subscribe(resposta => {
      this.service.successfulLogin(resposta.headers.get('Authorization').substring(7));
      this.router.navigate([''])
    }, () => {
      this.toast.error('Usuário e/ou senha inválidos');
    })
  }

  validaCampos(): boolean {
    return this.email.valid && this.senha.valid
  }
}
```

### Logout
#### Para o logout, adicionar no NavComponent HTML o clique da rota, e no typescript, a função de lougout
```html
        <a mat-list-item (click)="logout()">
            <i class="material-icons">logout</i>
            Logout
         </a>
```
```typescript
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(
    private router: Router,
    private authService: AuthService,
    private toast: ToastrService) { }

  ngOnInit(): void {
    this.router.navigate(['home'])
  }

  logout() {
    this.router.navigate(['login'])
    this.authService.logout();
    this.toast.info('Logout realizado com sucesso', 'Logout')
  }
}
```

###Interceptor
```typescript
import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HTTP_INTERCEPTORS
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = localStorage.getItem('token');

    if (token) {
      const cloneReq = 
        request.clone({ headers: request.headers.set('Authorization', `Bearer ${token}`) });
        return next.handle(cloneReq);
    } else {
      return next.handle(request);
    }
  }
}

export const AuthInterceptorProvider = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }
]
```
- Habilitar o provider no app.module

### Tecnico service
```typescript
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../config/api.config';
import { Tecnico } from '../models/tecnico';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Tecnico> {
    return this.http.get<Tecnico>(`${API_CONFIG.baseUrl}/tecnicos/${id}`);
  }

  findAll(): Observable<Tecnico[]> {
    return this.http.get<Tecnico[]>(`${API_CONFIG.baseUrl}/tecnicos`);
  }

  create(tecnico: Tecnico): Observable<Tecnico> {
    return this.http.post<Tecnico>(`${API_CONFIG.baseUrl}/tecnicos`, tecnico);
  }

  update(tecnico: Tecnico): Observable<Tecnico> {
    return this.http.put<Tecnico>(`${API_CONFIG.baseUrl}/tecnicos/${tecnico.id}`, tecnico);
  }

  delete(id: any): Observable<Tecnico> {
    return this.http.delete<Tecnico>(`${API_CONFIG.baseUrl}/tecnicos/${id}`);
  }
}
```
#### Métodos do tecnico lista
```typescript
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-list',
  templateUrl: './tecnico-list.component.html',
  styleUrls: ['./tecnico-list.component.css']
})
export class TecnicoListComponent implements OnInit {

  ELEMENT_DATA: Tecnico[] = []

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email', 'acoes'];
  dataSource = new MatTableDataSource<Tecnico>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private service: TecnicoService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.service.findAll().subscribe(resposta => {
      this.ELEMENT_DATA = resposta
      this.dataSource = new MatTableDataSource<Tecnico>(resposta);
      this.dataSource.paginator = this.paginator;
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
```
#### Aplicando filtro no tecnico-list.html
```html
    <mat-form-field appearance="standard">
       <mat-label>Filter</mat-label>
       <input matInput (keyup)="applyFilter($event)" placeholder="Ex. ium" #input>
     </mat-form-field>
```

### Tecnico Create
####
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-create',
  templateUrl: './tecnico-create.component.html',
  styleUrls: ['./tecnico-create.component.css']
})
export class TecnicoCreateComponent implements OnInit {

  tecnico: Tecnico = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  nome: FormControl =  new FormControl(null, Validators.minLength(3));
  cpf: FormControl =       new FormControl(null, Validators.required);
  email: FormControl =        new FormControl(null, Validators.email);
  senha: FormControl = new FormControl(null, Validators.minLength(3));

  constructor(
    private service: TecnicoService,
    private toast:    ToastrService,
    private router:          Router,
    ) { }

  ngOnInit(): void { }

  create(): void {
    this.service.create(this.tecnico).subscribe(() => {
      this.toast.success('Técnico cadastrado com sucesso', 'Cadastro');
      this.router.navigate(['tecnicos'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }

  addPerfil(perfil: any): void {
    if(this.tecnico.perfis.includes(perfil)) {
      this.tecnico.perfis.splice(this.tecnico.perfis.indexOf(perfil), 1);
    } else {
      this.tecnico.perfis.push(perfil);
    }
    
  }
  
  validaCampos(): boolean {
    return this.nome.valid && this.cpf.valid
     && this.email.valid && this.senha.valid
  }
}

```
####
```html
<div class="container mat-elevation-z8">
    <form class="form">
 
       <h1 class="fullWidth">Cadastrar Técnico</h1>
       <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">
 
       <section class="section">
          <mat-checkbox (click)="addPerfil(0)" class="margin" color="primary">Admin</mat-checkbox>
          <mat-checkbox (click)="addPerfil(1)" [checked]="true" class="margin" color="primary">Cliente</mat-checkbox>
          <mat-checkbox (click)="addPerfil(2)" class="margin" color="primary">Tecnico</mat-checkbox>
        </section>
 
        <mat-form-field class="fullWidth" appearance="legacy">
          <mat-label>Nome</mat-label>
          <input 
          [(ngModel)]="tecnico.nome"
          name="nome"
          [formControl]="nome"
          required
          matInput 
          placeholder="Ex.. fulano de tal"
          maxlength="50">
          <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
        </mat-form-field>
        
        <mat-form-field class="fullWidth" appearance="legacy">
          <mat-label>CPF</mat-label>
          <input 
          [(ngModel)]="tecnico.cpf"
          name="cpf"
          [formControl]="cpf"
          required
          matInput 
          placeholder="Ex..000.000.000-00"
          mask="000.000.000-00">
          <mat-icon matSuffix>pin </mat-icon>
        </mat-form-field>
 
        <mat-form-field class="fullWidth" appearance="legacy">
          <mat-label>E-mail</mat-label>
          <input 
          [(ngModel)]="tecnico.email"
          name="email"
          [formControl]="email"
          required
          matInput 
          placeholder="Ex.. fulano@mail.com">
          <mat-icon matSuffix>email</mat-icon>
        </mat-form-field>
 
        <mat-form-field class="fullWidth" appearance="legacy">
          <mat-label>Senha</mat-label>
          <input 
          [(ngModel)]="tecnico.senha"
          name="senha"
          [formControl]="senha"
          required
          type="password" 
          matInput 
          placeholder="Ex.. 1234">
          <mat-icon matSuffix>password</mat-icon>
        </mat-form-field>
 
        <button (click)="create()" [disabled]="!validaCampos()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Cadastrar</button>
        <button routerLink="../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
    </form>
 
    <p class="fullWidth"> </p>
 </div>
```
####
```css
.container {
    width: 35rem;
    margin: auto;
    padding: 1rem;
    border-radius: .6rem;
 }
 
 .fullWidth {
    width: 100%;
 }
 
 h1, p {
    text-align: center;
 }
 
 img {
    height: 12rem;
    margin: auto;
 }
 
 .section {
    margin-bottom: 1rem;
    display: flex;
    justify-content: space-between;
 }
 
 button {
    margin-top: .5rem;
 }
 
 p {
    margin-top: 4rem;
    opacity: .5;
 }
 
 mat-icon {
    opacity: .8;
 }
```
### Tecnico Update
####
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';


@Component({
  selector: 'app-tecnico-update',
  templateUrl: './tecnico-update.component.html',
  styleUrls: ['./tecnico-update.component.css']
})
export class TecnicoUpdateComponent implements OnInit {

  tecnico: Tecnico = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  nome: FormControl =  new FormControl(null, Validators.minLength(3));
  cpf: FormControl =       new FormControl(null, Validators.required);
  email: FormControl =        new FormControl(null, Validators.email);
  senha: FormControl = new FormControl(null, Validators.minLength(3));

  constructor(
    private service: TecnicoService,
    private toast:    ToastrService,
    private router:          Router,
    private route:   ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.tecnico.id = this.route.snapshot.paramMap.get('id');
    this.findById();
   }

  findById(): void {
    this.service.findById(this.tecnico.id).subscribe(resposta => {
      resposta.perfis = []
      this.tecnico = resposta;
    })
  }

  update(): void {
    this.service.update(this.tecnico).subscribe(() => {
      this.toast.success('Técnico atualizado com sucesso', 'Update');
      this.router.navigate(['tecnicos'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }

  addPerfil(perfil: any): void {
    if(this.tecnico.perfis.includes(perfil)) {
      this.tecnico.perfis.splice(this.tecnico.perfis.indexOf(perfil), 1);
    } else {
      this.tecnico.perfis.push(perfil);
    }
    
  }
  
  validaCampos(): boolean {
    return this.nome.valid && this.cpf.valid
     && this.email.valid && this.senha.valid
  }
}
```
####
```html
<div class="container mat-elevation-z8">
   <form class="form">

      <h1 class="fullWidth">Atualizar Técnico</h1>
      <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">

      <section class="section">
         <mat-checkbox (click)="addPerfil(0)" class="margin" color="primary">Admin</mat-checkbox>
         <mat-checkbox (click)="addPerfil(1)" [checked]="true" class="margin" color="primary">Cliente</mat-checkbox>
         <mat-checkbox (click)="addPerfil(2)" class="margin" color="primary">Tecnico</mat-checkbox>
       </section>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Nome</mat-label>
         <input 
         [(ngModel)]="tecnico.nome"
         name="nome"
         [formControl]="nome"
         required
         matInput 
         placeholder="Ex.. fulano de tal"
         maxlength="50">
         <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
       </mat-form-field>
       
       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>CPF</mat-label>
         <input 
         [(ngModel)]="tecnico.cpf"
         name="cpf"
         [formControl]="cpf"
         required
         matInput 
         placeholder="Ex..000.000.000-00"
         mask="000.000.000-00">
         <mat-icon matSuffix>pin </mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>E-mail</mat-label>
         <input 
         [(ngModel)]="tecnico.email"
         name="email"
         [formControl]="email"
         required
         matInput 
         placeholder="Ex.. fulano@mail.com">
         <mat-icon matSuffix>email</mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Senha</mat-label>
         <input 
         [(ngModel)]="tecnico.senha"
         name="senha"
         [formControl]="senha"
         required
         type="password" 
         matInput 
         placeholder="Ex.. 1234">
         <mat-icon matSuffix>password</mat-icon>
       </mat-form-field>

       <button (click)="update()" [disabled]="!validaCampos()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Atualizar</button>
       <button routerLink="../../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
   </form>

   <p class="fullWidth"> </p>
</div>
```
####
```css
.container {
   width: 35rem;
   margin: auto;
   padding: 1rem;
   border-radius: .6rem;
}

.fullWidth {
   width: 100%;
}

h1, p {
   text-align: center;
}

img {
   height: 12rem;
   margin: auto;
}

.section {
   margin-bottom: 1rem;
   display: flex;
   justify-content: space-between;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 4rem;
   opacity: .5;
}

mat-icon {
   opacity: .8;
}
```
### Tecnico delete
####
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Tecnico } from 'src/app/models/tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-delete',
  templateUrl: './tecnico-delete.component.html',
  styleUrls: ['./tecnico-delete.component.css']
})
export class TecnicoDeleteComponent implements OnInit {

  tecnico: Tecnico = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  constructor(
    private service: TecnicoService,
    private toast:    ToastrService,
    private router:          Router,
    private route:   ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.tecnico.id = this.route.snapshot.paramMap.get('id');
    this.findById();
   }

  findById(): void {
    this.service.findById(this.tecnico.id).subscribe(resposta => {
      resposta.perfis = []
      this.tecnico = resposta;
    })
  }

  delete(): void {
    this.service.delete(this.tecnico.id).subscribe(() => {
      this.toast.success('Técnico deletado com sucesso', 'Delete');
      this.router.navigate(['tecnicos'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }

}
```
####
```html
<div class="container mat-elevation-z8">
   <form class="form">

      <h1 class="fullWidth">Deletar Técnico</h1>
      <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">

      <section class="section">
         <mat-checkbox [disabled]="true" class="margin" color="primary">Admin</mat-checkbox>
         <mat-checkbox [disabled]="true" class="margin" color="primary">Cliente</mat-checkbox>
         <mat-checkbox [disabled]="true" class="margin" color="primary">Tecnico</mat-checkbox>
       </section>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Nome</mat-label>
         <input 
         [(ngModel)]="tecnico.nome"
         name="nome"
         [disabled]="true"
         matInput 
         >
         <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
       </mat-form-field>
       
       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>CPF</mat-label>
         <input 
         [(ngModel)]="tecnico.cpf"
         name="cpf"
         [disabled]="true"
         matInput >
         <mat-icon matSuffix>pin </mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>E-mail</mat-label>
         <input 
         [(ngModel)]="tecnico.email"
         name="email"
         [disabled]="true"
         matInput >
         <mat-icon matSuffix>email</mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Senha</mat-label>
         <input 
         [(ngModel)]="tecnico.senha"
         name="senha"
         [disabled]="true"
         matInput 
         type="password">
         <mat-icon matSuffix>password</mat-icon>
       </mat-form-field>

       <button (click)="delete()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Deletar</button>
       <button routerLink="../../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
   </form>

   <p class="fullWidth"> </p>
</div>
```
####
```css
.container {
   width: 35rem;
   margin: auto;
   padding: 1rem;
   border-radius: .6rem;
}

.fullWidth {
   width: 100%;
}

h1, p {
   text-align: center;
}

img {
   height: 12rem;
   margin: auto;
}

.section {
   margin-bottom: 1rem;
   display: flex;
   justify-content: space-between;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 4rem;
   opacity: .5;
}

mat-icon {
   opacity: .8;
}
```
###Cliente CRUD
#### Service
```typescript
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../config/api.config';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Cliente> {
    return this.http.get<Cliente>(`${API_CONFIG.baseUrl}/clientes/${id}`);
  }

  findAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${API_CONFIG.baseUrl}/clientes`);
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${API_CONFIG.baseUrl}/clientes`, cliente);
  }

  update(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${API_CONFIG.baseUrl}/clientes/${cliente.id}`, cliente);
  }

  delete(id: any): Observable<Cliente> {
    return this.http.delete<Cliente>(`${API_CONFIG.baseUrl}/clientes/${id}`);
  }
}
```
#### Cliente List
```typescript
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  ELEMENT_DATA: Cliente[] = []

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email', 'acoes'];
  dataSource = new MatTableDataSource<Cliente>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private service: ClienteService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.service.findAll().subscribe(resposta => {
      this.ELEMENT_DATA = resposta
      this.dataSource = new MatTableDataSource<Cliente>(resposta);
      this.dataSource.paginator = this.paginator;
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
```
####
```html
<div class="container">

   <h1>Listando Clientes</h1>

   <button routerLink="create" class="mat-elevation-z8" mat-stroked-button color="primary">Novo cliente</button>

   <mat-form-field appearance="standard">
      <mat-label>Filter</mat-label>
      <input matInput (keyup)="applyFilter($event)" placeholder="Ex. ium" #input>
    </mat-form-field>

   <div class="mat-elevation-z8">

      <table mat-table [dataSource]="dataSource">

         <ng-container matColumnDef="id">
            <th mat-header-cell *matHeaderCellDef> ID </th>
            <td mat-cell *matCellDef="let element"> {{element.id}} </td>
         </ng-container>

         <ng-container matColumnDef="nome">
            <th mat-header-cell *matHeaderCellDef> Nome </th>
            <td mat-cell *matCellDef="let element"> {{element.nome}} </td>
         </ng-container>

         <ng-container matColumnDef="cpf">
            <th mat-header-cell *matHeaderCellDef> CPF </th>
            <td mat-cell *matCellDef="let element"> {{element.cpf}} </td>
         </ng-container>

         <ng-container matColumnDef="email">
            <th mat-header-cell *matHeaderCellDef> Email </th>
            <td mat-cell *matCellDef="let element"> {{element.email}} </td>
         </ng-container>

         <ng-container matColumnDef="acoes">
            <th mat-header-cell *matHeaderCellDef> Ações </th>
            <td mat-cell *matCellDef="let element">
               <a routerLink="update/{{ element.id }}">
                  <i class="material-icons edit">edit</i>
               </a>
               <a routerLink="delete/{{ element.id }}">
                  <i class="material-icons delete">delete</i>
               </a>
            </td>
         </ng-container>

         <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
         <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
      </table>

      <mat-paginator [pageSizeOptions]="[5, 2, 10, 20, 50, 100]" showFirstLastButtons></mat-paginator>
   </div>

</div>
```
####
```css
.container {
   width: 90%;
   margin: auto;
}

table {
   width: 100%;
}

mat-form-field {
   width: 100%;
}

button {
   width: 100%;
}

h1 {
   width: 100%;
   text-align: center;
   margin-bottom: 2rem;
}

.edit {
   color: rgb(0, 153, 255);
}

.delete {
   color: red;
}
```
#### Cliente create
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit {

  cliente: Cliente = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  nome: FormControl =  new FormControl(null, Validators.minLength(3));
  cpf: FormControl =       new FormControl(null, Validators.required);
  email: FormControl =        new FormControl(null, Validators.email);
  senha: FormControl = new FormControl(null, Validators.minLength(3));

  constructor(
    private service: ClienteService,
    private toast:    ToastrService,
    private router:          Router,
    ) { }

  ngOnInit(): void { }

  create(): void {
    this.service.create(this.cliente).subscribe(() => {
      this.toast.success('Cliente cadastrado com sucesso', 'Cadastro');
      this.router.navigate(['clientes'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }

  addPerfil(perfil: any): void {
    if(this.cliente.perfis.includes(perfil)) {
      this.cliente.perfis.splice(this.cliente.perfis.indexOf(perfil), 1);
    } else {
      this.cliente.perfis.push(perfil);
    }
    
  }
  
  validaCampos(): boolean {
    return this.nome.valid && this.cpf.valid
     && this.email.valid && this.senha.valid
  }
}

```
####
```html
<div class="container mat-elevation-z8">
   <form class="form">

      <h1 class="fullWidth">Cadastrar Cliente</h1>
      <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">

      <section class="section">
         <mat-checkbox (click)="addPerfil(0)" class="margin" color="primary">Admin</mat-checkbox>
         <mat-checkbox (click)="addPerfil(1)" [checked]="true" class="margin" color="primary">Cliente</mat-checkbox>
         <mat-checkbox (click)="addPerfil(2)" class="margin" color="primary">Cliente</mat-checkbox>
       </section>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Nome</mat-label>
         <input 
         [(ngModel)]="cliente.nome"
         name="nome"
         [formControl]="nome"
         required
         matInput 
         placeholder="Ex.. fulano de tal"
         maxlength="50">
         <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
       </mat-form-field>
       
       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>CPF</mat-label>
         <input 
         [(ngModel)]="cliente.cpf"
         name="cpf"
         [formControl]="cpf"
         required
         matInput 
         placeholder="Ex..000.000.000-00"
         mask="000.000.000-00">
         <mat-icon matSuffix>pin </mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>E-mail</mat-label>
         <input 
         [(ngModel)]="cliente.email"
         name="email"
         [formControl]="email"
         required
         matInput 
         placeholder="Ex.. fulano@mail.com">
         <mat-icon matSuffix>email</mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Senha</mat-label>
         <input 
         [(ngModel)]="cliente.senha"
         name="senha"
         [formControl]="senha"
         required
         type="password" 
         matInput 
         placeholder="Ex.. 1234">
         <mat-icon matSuffix>password</mat-icon>
       </mat-form-field>

       <button (click)="create()" [disabled]="!validaCampos()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Cadastrar</button>
       <button routerLink="../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
   </form>

   <p class="fullWidth"> </p>
</div>
```
####
```css
.container {
   width: 35rem;
   margin: auto;
   padding: 1rem;
   border-radius: .6rem;
}

.fullWidth {
   width: 100%;
}

h1, p {
   text-align: center;
}

img {
   height: 12rem;
   margin: auto;
}

.section {
   margin-bottom: 1rem;
   display: flex;
   justify-content: space-between;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 4rem;
   opacity: .5;
}

mat-icon {
   opacity: .8;
}
```
#### Cliente update
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';


@Component({
  selector: 'app-cliente-update',
  templateUrl: './cliente-update.component.html',
  styleUrls: ['./cliente-update.component.css']
})
export class ClienteUpdateComponent implements OnInit {

  cliente: Cliente = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  nome: FormControl =  new FormControl(null, Validators.minLength(3));
  cpf: FormControl =       new FormControl(null, Validators.required);
  email: FormControl =        new FormControl(null, Validators.email);
  senha: FormControl = new FormControl(null, Validators.minLength(3));

  constructor(
    private service: ClienteService,
    private toast:    ToastrService,
    private router:          Router,
    private route:   ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.cliente.id = this.route.snapshot.paramMap.get('id');
    this.findById();
   }

  findById(): void {
    this.service.findById(this.cliente.id).subscribe(resposta => {
      resposta.perfis = []
      this.cliente = resposta;
    })
  }

  update(): void {
    this.service.update(this.cliente).subscribe(() => {
      this.toast.success('Cliente atualizado com sucesso', 'Update');
      this.router.navigate(['clientes'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }

  addPerfil(perfil: any): void {
    if(this.cliente.perfis.includes(perfil)) {
      this.cliente.perfis.splice(this.cliente.perfis.indexOf(perfil), 1);
    } else {
      this.cliente.perfis.push(perfil);
    }
    
  }
  
  validaCampos(): boolean {
    return this.nome.valid && this.cpf.valid
     && this.email.valid && this.senha.valid
  }
}
```
####
```html
<div class="container mat-elevation-z8">
   <form class="form">

      <h1 class="fullWidth">Atualizar Cliente</h1>
      <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">

      <section class="section">
         <mat-checkbox (click)="addPerfil(0)" class="margin" color="primary">Admin</mat-checkbox>
         <mat-checkbox (click)="addPerfil(1)" [checked]="true" class="margin" color="primary">Cliente</mat-checkbox>
         <mat-checkbox (click)="addPerfil(2)" class="margin" color="primary">Cliente</mat-checkbox>
       </section>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Nome</mat-label>
         <input 
         [(ngModel)]="cliente.nome"
         name="nome"
         [formControl]="nome"
         required
         matInput 
         placeholder="Ex.. fulano de tal"
         maxlength="50">
         <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
       </mat-form-field>
       
       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>CPF</mat-label>
         <input 
         [(ngModel)]="cliente.cpf"
         name="cpf"
         [formControl]="cpf"
         required
         matInput 
         placeholder="Ex..000.000.000-00"
         mask="000.000.000-00">
         <mat-icon matSuffix>pin </mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>E-mail</mat-label>
         <input 
         [(ngModel)]="cliente.email"
         name="email"
         [formControl]="email"
         required
         matInput 
         placeholder="Ex.. fulano@mail.com">
         <mat-icon matSuffix>email</mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Senha</mat-label>
         <input 
         [(ngModel)]="cliente.senha"
         name="senha"
         [formControl]="senha"
         required
         type="password" 
         matInput 
         placeholder="Ex.. 1234">
         <mat-icon matSuffix>password</mat-icon>
       </mat-form-field>

       <button (click)="update()" [disabled]="!validaCampos()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Atualizar</button>
       <button routerLink="../../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
   </form>

   <p class="fullWidth"> </p>
</div>
```
####
```css
.container {
   width: 35rem;
   margin: auto;
   padding: 1rem;
   border-radius: .6rem;
}

.fullWidth {
   width: 100%;
}

h1, p {
   text-align: center;
}

img {
   height: 12rem;
   margin: auto;
}

.section {
   margin-bottom: 1rem;
   display: flex;
   justify-content: space-between;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 4rem;
   opacity: .5;
}

mat-icon {
   opacity: .8;
}
```
#### Cliente delete
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-delete',
  templateUrl: './cliente-delete.component.html',
  styleUrls: ['./cliente-delete.component.css']
})
export class ClienteDeleteComponent implements OnInit {

  cliente: Cliente = {
    id:         '',
    nome:       '',
    cpf:        '',
    email:      '',
    senha:      '',
    perfis:     [],
    dataCriacao: ''
  }

  constructor(
    private service: ClienteService,
    private toast:    ToastrService,
    private router:          Router,
    private route:   ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.cliente.id = this.route.snapshot.paramMap.get('id');
    this.findById();
   }

  findById(): void {
    this.service.findById(this.cliente.id).subscribe(resposta => {
      resposta.perfis = []
      this.cliente = resposta;
    })
  }

  delete(): void {
    this.service.delete(this.cliente.id).subscribe(() => {
      this.toast.success('Cliente deletado com sucesso', 'Delete');
      this.router.navigate(['clientes'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach(element => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }
}
```
####
```html
<div class="container mat-elevation-z8">
   <form class="form">

      <h1 class="fullWidth">Deletar Cliente</h1>
      <img class="fullWidth" src="assets/img/tecnico-create.svg" alt="Help Desk - Dicas de um DEV">

      <section class="section">
         <mat-checkbox [disabled]="true" class="margin" color="primary">Admin</mat-checkbox>
         <mat-checkbox [disabled]="true" class="margin" color="primary">Cliente</mat-checkbox>
         <mat-checkbox [disabled]="true" class="margin" color="primary">Cliente</mat-checkbox>
       </section>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Nome</mat-label>
         <input 
         [(ngModel)]="cliente.nome"
         name="nome"
         [disabled]="true"
         matInput 
         >
         <mat-icon matSuffix>sentiment_very_satisfied</mat-icon>
       </mat-form-field>
       
       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>CPF</mat-label>
         <input 
         [(ngModel)]="cliente.cpf"
         name="cpf"
         [disabled]="true"
         matInput >
         <mat-icon matSuffix>pin </mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>E-mail</mat-label>
         <input 
         [(ngModel)]="cliente.email"
         name="email"
         [disabled]="true"
         matInput >
         <mat-icon matSuffix>email</mat-icon>
       </mat-form-field>

       <mat-form-field class="fullWidth" appearance="legacy">
         <mat-label>Senha</mat-label>
         <input 
         [(ngModel)]="cliente.senha"
         name="senha"
         [disabled]="true"
         matInput 
         type="password">
         <mat-icon matSuffix>password</mat-icon>
       </mat-form-field>

       <button (click)="delete()" class="fullWidth mat-elevation-z4" mat-flat-button color="primary">Deletar</button>
       <button routerLink="../../" class="fullWidth mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>
   </form>

   <p class="fullWidth"> </p>
</div>
```
####
```css
.container {
   width: 35rem;
   margin: auto;
   padding: 1rem;
   border-radius: .6rem;
}

.fullWidth {
   width: 100%;
}

h1, p {
   text-align: center;
}

img {
   height: 12rem;
   margin: auto;
}

.section {
   margin-bottom: 1rem;
   display: flex;
   justify-content: space-between;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 4rem;
   opacity: .5;
}

mat-icon {
   opacity: .8;
}
```
### Chamado
####Service
```typescript
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_CONFIG } from '../config/api.config';
import { Chamado } from '../models/chamado';

@Injectable({
  providedIn: 'root'
})
export class ChamadoService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Chamado> {
    return this.http.get<Chamado>(`${API_CONFIG.baseUrl}/chamados/${id}`);
  }

  findAll(): Observable<Chamado[]> {
    return this.http.get<Chamado[]>(`${API_CONFIG.baseUrl}/chamados`);
  }

  create(chamado: Chamado): Observable<Chamado> {
    return this.http.post<Chamado>(`${API_CONFIG.baseUrl}/chamados`, chamado);
  }

  update(chamado: Chamado): Observable<Chamado> {
    return this.http.put<Chamado>(`${API_CONFIG.baseUrl}/chamados/${chamado.id}`, chamado);
  }
}
```
#### Chamado list
```typescript
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Chamado } from 'src/app/models/chamado';
import { ChamadoService } from 'src/app/services/chamado.service';

@Component({
  selector: 'app-chamado-list',
  templateUrl: './chamado-list.component.html',
  styleUrls: ['./chamado-list.component.css']
})
export class ChamadoListComponent implements OnInit {

  ELEMENT_DATA: Chamado[] = []
  FILTERED_DATA: Chamado[] = []

  displayedColumns: string[] = ['id', 'titulo', 'cliente', 'tecnico', 'dataAbertura', 'prioridade', 'status', 'acoes'];
  dataSource = new MatTableDataSource<Chamado>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(
    private service: ChamadoService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe(resposta => {
      this.ELEMENT_DATA = resposta;
      this.dataSource = new MatTableDataSource<Chamado>(resposta);
      this.dataSource.paginator = this.paginator;
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  retornaStatus(status: any): string {
    if(status == '0') {
      return 'ABERTO'
    } else if(status == '1') {
      return 'EM ANDAMENTO'
    } else {
      return 'ENCERRADO'
    }
  }

  retornaPrioridade(prioridade: any): string {
    if(prioridade == '0') {
      return 'BAIXA'
    } else if(prioridade == '1') {
      return 'MÉDIA'
    } else {
      return 'ALTA'
    }
  }

  orderByStatus(status: any): void{
    let list: Chamado[] = []
    this.ELEMENT_DATA.forEach(element => {
      if(element.status == status)
        list.push(element)
    });
    this.FILTERED_DATA = list;
    this.dataSource = new MatTableDataSource<Chamado>(list);
    this.dataSource.paginator = this.paginator;
  }

}
```
####
```html
<div class="container">

   <h1>Listando chamados</h1>

   <button routerLink="create" class="mat-elevation-z8" mat-stroked-button color="primary">Novo chamado</button>
 
   <mat-form-field appearance="standard">
      <mat-label>Filter</mat-label>
      <input matInput (keyup)="applyFilter($event)" placeholder="Ex. ium" #input>
    </mat-form-field>

    <mat-radio-group color="primary">
      <mat-radio-button (click)="orderByStatus(0)" value="0">ABERTO</mat-radio-button>
      <mat-radio-button (click)="orderByStatus(1)" value="1">ANDAMENTO</mat-radio-button>
      <mat-radio-button (click)="orderByStatus(2)" value="2">ENCERRADO</mat-radio-button>
    </mat-radio-group>

   <div class="mat-elevation-z8">

      <table mat-table [dataSource]="dataSource">

         <ng-container matColumnDef="id">
            <th mat-header-cell *matHeaderCellDef> ID </th>
            <td mat-cell *matCellDef="let element"> {{element.id}} </td>
         </ng-container>

         <ng-container matColumnDef="titulo">
            <th mat-header-cell *matHeaderCellDef> Titulo </th>
            <td mat-cell *matCellDef="let element"> {{element.titulo}} </td>
         </ng-container>

         <ng-container matColumnDef="cliente">
            <th mat-header-cell *matHeaderCellDef> Cliente </th>
            <td mat-cell *matCellDef="let element"> {{element.nomeCliente}} </td>
         </ng-container>

         <ng-container matColumnDef="tecnico">
            <th mat-header-cell *matHeaderCellDef> Técnico </th>
            <td mat-cell *matCellDef="let element"> {{element.nomeTecnico}} </td>
         </ng-container>

         <ng-container matColumnDef="dataAbertura">
            <th mat-header-cell *matHeaderCellDef> Data de Abertura </th>
            <td mat-cell *matCellDef="let element"> {{element.dataAbertura}} </td>
         </ng-container>

         <ng-container matColumnDef="prioridade">
            <th mat-header-cell *matHeaderCellDef> Prioridade </th>
            <td mat-cell *matCellDef="let element"> {{retornaPrioridade(element.prioridade)}} </td>
         </ng-container>

         <ng-container matColumnDef="status">
            <th mat-header-cell *matHeaderCellDef> Status </th>
            <td mat-cell *matCellDef="let element"> {{retornaStatus(element.status)}} </td>
         </ng-container>

         <ng-container matColumnDef="acoes">
            <th mat-header-cell *matHeaderCellDef> Ações </th>
            <td mat-cell *matCellDef="let element">
               <a routerLink="update/{{ element.id }}">
                  <i class="material-icons edit">edit</i>
               </a>
               <a routerLink="read/{{ element.id }}">
                  <i class="material-icons delete">visibility</i>
               </a>
            </td>
         </ng-container>

         <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
         <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>
      </table>

      <mat-paginator [pageSizeOptions]="[5, 2, 10, 20, 50, 100]" showFirstLastButtons></mat-paginator>
   </div>

</div>
```
####
```css
.container {
   width: 90%;
   margin: auto;
}

table {
   width: 100%;
}

mat-form-field {
   width: 100%;
}

button {
   width: 100%;
}

h1 {
   width: 100%;
   text-align: center;
   margin-bottom: 2rem;
}

.edit {
   color: rgb(0, 153, 255);
}

.delete {
   color: red;
}

mat-radio-group {
   display: flex;
   justify-content: space-around;
   margin-bottom: 1rem;
}
```
#### Chamado create
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Chamado } from 'src/app/models/chamado';
import { Cliente } from 'src/app/models/cliente';
import { Tecnico } from 'src/app/models/tecnico';
import { ChamadoService } from 'src/app/services/chamado.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-chamado-create',
  templateUrl: './chamado-create.component.html',
  styleUrls: ['./chamado-create.component.css']
})
export class ChamadoCreateComponent implements OnInit {

  chamado: Chamado = {
    prioridade:  '',
    status:      '',
    titulo:      '',
    observacoes: '',
    tecnico:     '',
    cliente:     '',
    nomeCliente: '',
    nomeTecnico: '',
  }

  clientes: Cliente[] = []
  tecnicos: Tecnico[] = []

  prioridade: FormControl = new FormControl(null, [Validators.required]);
  status:     FormControl = new FormControl(null, [Validators.required]);
  titulo:     FormControl = new FormControl(null, [Validators.required]);
  observacoes:FormControl = new FormControl(null, [Validators.required]);
  tecnico:    FormControl = new FormControl(null, [Validators.required]);
  cliente:    FormControl = new FormControl(null, [Validators.required]);

  constructor(
    private chamadoService: ChamadoService,
    private clienteService: ClienteService,
    private tecnicoService: TecnicoService,
    private toastService:    ToastrService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.findAllClientes();
    this.findAllTecnicos();
  }

  create(): void {
    this.chamadoService.create(this.chamado).subscribe(resposta => {
      this.toastService.success('Chamado criado com sucesso', 'Novo chamado');
      this.router.navigate(['chamados']);
    }, ex => {
      console.log(ex);
      
      this.toastService.error(ex.error.error);
    })
  }

  findAllClientes(): void {
    this.clienteService.findAll().subscribe(resposta => {
      this.clientes = resposta;
    })
  }

  findAllTecnicos(): void {
    this.tecnicoService.findAll().subscribe(resposta => {
      this.tecnicos = resposta;
    })
  }

  validaCampos(): boolean {
    return this.prioridade.valid && this.status.valid && this.titulo.valid 
       && this.observacoes.valid && this.tecnico.valid && this.cliente.valid
  }

}

```
####
```html
<div class="container mat-elevation-z8">
   <h1 class="full-width">Criando chamado</h1>
   <img class="full-width" src="assets/img/chamado-create.svg" alt="Chamado image">

   <form class="form">
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Título do chamado</mat-label>
        <input 
        [(ngModel)]="chamado.titulo"
        name="titulo"
        [formControl]="titulo"
        required
        matInput 
        placeholder="Ex. Trocar bateria de notebook">
      </mat-form-field>
    </form>

    <div class="status-prioridade">
      <mat-form-field appearance="outline">
         <mat-label>Selecione um status</mat-label>
         <mat-select 
         [(ngModel)]="chamado.status"
         name="status"
         [formControl]="status" 
         required>
           <mat-option value="0">ABERTO</mat-option>
           <mat-option value="1">EM ANDAMENTO</mat-option>
           <mat-option value="2">ENCERRADO</mat-option>
         </mat-select>
       </mat-form-field>

       <mat-form-field appearance="outline">
         <mat-label>Selecione uma prioridade</mat-label>
         <mat-select 
         [(ngModel)]="chamado.prioridade"
         name="prioridade"
         [formControl]="prioridade" 
         required>
           <mat-option value="0">BAIXA</mat-option>
           <mat-option value="1">MÉDIA</mat-option>
           <mat-option value="2">ALTA</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="tecnico">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>Selecione um técnico</mat-label>
         <mat-select 
         [(ngModel)]="chamado.tecnico"
         name="tecnico"
         [formControl]="tecnico" 
         required>
           <mat-option *ngFor="let tec of tecnicos" value="{{ tec.id }}">{{ tec.nome }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="cliente">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>Selecione um cliente</mat-label>
         <mat-select 
         [(ngModel)]="chamado.cliente"
         name="cliente"
         [formControl]="cliente" 
         required>
           <mat-option *ngFor="let cli of clientes" value="{{ cli.id }}">{{ cli.nome }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <form class="form">  
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Deixe uma observação</mat-label>
        <textarea 
        [(ngModel)]="chamado.observacoes"
        name="observacoes"
        [formControl]="observacoes"
        required
        class="observacoes" 
        matInput 
        placeholder="Ex. trocar bateria de notebook queimada..."></textarea>
      </mat-form-field>
    </form>

    <button (click)="create()" [disabled]="!validaCampos()" class="full-width mat-elevation-z4" mat-raised-button color="primary">Adicionar</button>
    <button routerLink="../" class="full-width mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>

    <p class="full-width"> </p>
</div>
```
####
```css
.container {
   width: 45%;
   margin: auto auto 3rem auto;
   padding: 1rem;
   border-radius: 1rem;
}

.full-width {
   width: 100%;
}

h1, img, p{
   text-align: center;
}

img {
   height: 15rem;
}

.status-prioridade {
   display: flex;
   justify-content: space-between;
}

.status-prioridade mat-form-field {
   width: 49%;
}

.observacoes {
   min-height: 6rem;
   max-height: 10rem;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 3rem;
   opacity: .5;
}
```
###
#### Chamado update
```typescript
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Chamado } from 'src/app/models/chamado';
import { Cliente } from 'src/app/models/cliente';
import { Tecnico } from 'src/app/models/tecnico';
import { ChamadoService } from 'src/app/services/chamado.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-chamado-update',
  templateUrl: './chamado-update.component.html',
  styleUrls: ['./chamado-update.component.css']
})
export class ChamadoUpdateComponent implements OnInit {

  chamado: Chamado = {
    prioridade:  '',
    status:      '',
    titulo:      '',
    observacoes: '',
    tecnico:     '',
    cliente:     '',
    nomeCliente: '',
    nomeTecnico: '',
  }

  clientes: Cliente[] = []
  tecnicos: Tecnico[] = []

  prioridade: FormControl = new FormControl(null, [Validators.required]);
  status:     FormControl = new FormControl(null, [Validators.required]);
  titulo:     FormControl = new FormControl(null, [Validators.required]);
  observacoes:FormControl = new FormControl(null, [Validators.required]);
  tecnico:    FormControl = new FormControl(null, [Validators.required]);
  cliente:    FormControl = new FormControl(null, [Validators.required]);

  constructor(
    private chamadoService: ChamadoService,
    private clienteService: ClienteService,
    private tecnicoService: TecnicoService,
    private toastService:    ToastrService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.chamado.id = this.route.snapshot.paramMap.get('id');
    this.findById();
    this.findAllClientes();
    this.findAllTecnicos();
  }

  findById(): void {
    this.chamadoService.findById(this.chamado.id).subscribe(resposta => {
      this.chamado = resposta;
    }, ex => {
      this.toastService.error(ex.error.error);
    })
  }

  update(): void {
    this.chamadoService.update(this.chamado).subscribe(resposta => {
      this.toastService.success('Chamado atualizado com sucesso', 'Atualizar chamado');
      this.router.navigate(['chamados']);
    }, ex => {
      this.toastService.error(ex.error.error);
    })
  }

  findAllClientes(): void {
    this.clienteService.findAll().subscribe(resposta => {
      this.clientes = resposta;
    })
  }

  findAllTecnicos(): void {
    this.tecnicoService.findAll().subscribe(resposta => {
      this.tecnicos = resposta;
    })
  }

  validaCampos(): boolean {
    return this.prioridade.valid && this.status.valid && this.titulo.valid 
       && this.observacoes.valid && this.tecnico.valid && this.cliente.valid
  }

  retornaStatus(status: any): string {
    if(status == '0') {
      return 'ABERTO'
    } else if(status == '1') {
      return 'EM ANDAMENTO'
    } else {
      return 'ENCERRADO'
    }
  }

  retornaPrioridade(prioridade: any): string {
    if(prioridade == '0') {
      return 'BAIXA'
    } else if(prioridade == '1') {
      return 'MÉDIA'
    } else {
      return 'ALTA'
    }
  }
  
}
```
####
```html
<div class="container mat-elevation-z8">
   <h1 class="full-width">Atualizando chamado</h1>
   <img class="full-width" src="assets/img/chamado-create.svg" alt="Chamado image">

   <form class="form">
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Título do chamado</mat-label>
        <input 
        [(ngModel)]="chamado.titulo"
        name="titulo"
        [formControl]="titulo"
        required
        matInput 
        placeholder="Ex. Trocar bateria de notebook">
      </mat-form-field>
    </form>

    <div class="status-prioridade">
      <mat-form-field appearance="outline">
         <mat-label>STATUS ({{ retornaStatus(chamado.status) }})</mat-label>
         <mat-select 
         [(ngModel)]="chamado.status"
         name="status"
         [formControl]="status" 
         required>
           <mat-option value="0">ABERTO</mat-option>
           <mat-option value="1">EM ANDAMENTO</mat-option>
           <mat-option value="2">ENCERRADO</mat-option>
         </mat-select>
       </mat-form-field>

       <mat-form-field appearance="outline">
         <mat-label>PRIORIDADE ({{ retornaPrioridade(chamado.prioridade) }})</mat-label>
         <mat-select 
         [(ngModel)]="chamado.prioridade"
         name="prioridade"
         [formControl]="prioridade" 
         required>
           <mat-option value="0">BAIXA</mat-option>
           <mat-option value="1">MÉDIA</mat-option>
           <mat-option value="2">ALTA</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="tecnico">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>TÉCNICO ({{ chamado.nomeTecnico }})</mat-label>
         <mat-select 
         [(ngModel)]="chamado.tecnico"
         name="tecnico"
         [formControl]="tecnico" 
         required>
           <mat-option *ngFor="let tec of tecnicos" value="{{ tec.id }}">{{ tec.nome }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="cliente">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>CLIENTE ({{ chamado.nomeCliente }})</mat-label>
         <mat-select 
         [(ngModel)]="chamado.cliente"
         name="cliente"
         [formControl]="cliente" 
         required>
           <mat-option *ngFor="let cli of clientes" value="{{ cli.id }}">{{ cli.nome }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <form class="form">  
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Deixe uma observação</mat-label>
        <textarea 
        [(ngModel)]="chamado.observacoes"
        name="observacoes"
        [formControl]="observacoes"
        required
        class="observacoes" 
        matInput 
        placeholder="Ex. trocar bateria de notebook queimada..."></textarea>
      </mat-form-field>
    </form>

    <button (click)="update()" [disabled]="!validaCampos()" class="full-width mat-elevation-z4" mat-raised-button color="primary">Atualizar</button>
    <button routerLink="../../" class="full-width mat-elevation-z4" mat-stroked-button color="warn">Cancelar</button>

    <p class="full-width"> </p>
</div>
```
####
```css
.container {
   width: 45%;
   margin: auto auto 3rem auto;
   padding: 1rem;
   border-radius: 1rem;
}

.full-width {
   width: 100%;
}

h1, img, p{
   text-align: center;
}

img {
   height: 15rem;
}

.status-prioridade {
   display: flex;
   justify-content: space-between;
}

.status-prioridade mat-form-field {
   width: 49%;
}

.observacoes {
   min-height: 6rem;
   max-height: 10rem;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 3rem;
   opacity: .5;
}
```
###
#### Chamado read
```typescript
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Chamado } from 'src/app/models/chamado';
import { ChamadoService } from 'src/app/services/chamado.service';

@Component({
  selector: 'app-chamado-read',
  templateUrl: './chamado-read.component.html',
  styleUrls: ['./chamado-read.component.css']
})
export class ChamadoReadComponent implements OnInit {

  chamado: Chamado = {
    prioridade:  '',
    status:      '',
    titulo:      '',
    observacoes: '',
    tecnico:     '',
    cliente:     '',
    nomeCliente: '',
    nomeTecnico: '',
  }

  constructor(
    private chamadoService: ChamadoService,
    private toastService:    ToastrService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.chamado.id = this.route.snapshot.paramMap.get('id');
    this.findById();
  }

  findById(): void {
    this.chamadoService.findById(this.chamado.id).subscribe(resposta => {
      this.chamado = resposta;
    }, ex => {
      this.toastService.error(ex.error.error);
    })
  }

  retornaStatus(status: any): string {
    if(status == '0') {
      return 'ABERTO'
    } else if(status == '1') {
      return 'EM ANDAMENTO'
    } else {
      return 'ENCERRADO'
    }
  }

  retornaPrioridade(prioridade: any): string {
    if(prioridade == '0') {
      return 'BAIXA'
    } else if(prioridade == '1') {
      return 'MÉDIA'
    } else {
      return 'ALTA'
    }
  }
  
}

```
####
```html
<div class="container mat-elevation-z8">
   <h1 class="full-width">Leitura de chamado</h1>
   <img class="full-width" src="assets/img/chamado-create.svg" alt="Chamado image">

   <form class="form">
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Título do chamado</mat-label>
        <input 
        [disabled]="true"
        [(ngModel)]="chamado.titulo"
        name="titulo"
        matInput 
        placeholder="Ex. Trocar bateria de notebook">
      </mat-form-field>
    </form>

    <div class="status-prioridade">
      <mat-form-field appearance="outline">
         <mat-label>STATUS ({{ retornaStatus(chamado.status) }})</mat-label>
         <mat-select 
         [disabled]="true"
         [(ngModel)]="chamado.status"
         name="status">
           <mat-option value="0">ABERTO</mat-option>
           <mat-option value="1">EM ANDAMENTO</mat-option>
           <mat-option value="2">ENCERRADO</mat-option>
         </mat-select>
       </mat-form-field>

       <mat-form-field appearance="outline">
         <mat-label>PRIORIDADE ({{ retornaPrioridade(chamado.prioridade) }})</mat-label>
         <mat-select 
         [disabled]="true"
         [(ngModel)]="chamado.prioridade"
         name="prioridade">
           <mat-option value="0">BAIXA</mat-option>
           <mat-option value="1">MÉDIA</mat-option>
           <mat-option value="2">ALTA</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="tecnico">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>TÉCNICO ({{ chamado.nomeTecnico }})</mat-label>
         <mat-select 
         [disabled]="true"
         [(ngModel)]="chamado.tecnico"
         name="tecnico">
           <mat-option>{{ chamado.nomeTecnico }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <div class="cliente">
      <mat-form-field class="full-width" appearance="outline">
         <mat-label>CLIENTE ({{ chamado.nomeCliente }})</mat-label>
         <mat-select 
         [disabled]="true"
         [(ngModel)]="chamado.cliente"
         name="cliente">
           <mat-option>{{ chamado.nomeCliente }}</mat-option>
         </mat-select>
       </mat-form-field>
    </div>

    <form class="form">  
      <mat-form-field class="full-width" appearance="outline">
        <mat-label>Deixe uma observação</mat-label>
        <textarea 
        [disabled]="true"
        [(ngModel)]="chamado.observacoes"
        name="observacoes"
        class="observacoes" 
        matInput 
        ></textarea>
      </mat-form-field>
    </form>

    <button routerLink="../../" class="full-width mat-elevation-z4" mat-stroked-button color="warn">Retornar</button>

    <p class="full-width"> </p>
</div>
```
####
```css
.container {
   width: 45%;
   margin: auto auto 3rem auto;
   padding: 1rem;
   border-radius: 1rem;
}

.full-width {
   width: 100%;
}

h1, img, p{
   text-align: center;
}

img {
   height: 15rem;
}

.status-prioridade {
   display: flex;
   justify-content: space-between;
}

.status-prioridade mat-form-field {
   width: 49%;
}

.observacoes {
   min-height: 6rem;
   max-height: 10rem;
}

button {
   margin-top: .5rem;
}

p {
   margin-top: 3rem;
   opacity: .5;
}
```


