
# Guía documentada de Git y GitHub — *Práctica de Campo*
**Alumno:** Renzo Alexander Palomino (re286estudentupn-svg)  
**Curso:** Técnicas de programación orientada a objetos  
**Docente:** Torres Rodríguez, Martin Eduardo  
**Repositorio:** https://github.com/re286estudentupn-svg/mi-primer-project

---

## 0) Prerrequisitos
- Git para Windows instalado (`git --version`).
- Cuenta de GitHub activa e iniciada en el navegador.
- Configurar identidad (una sola vez en el equipo):
```bat
git config --global user.name "Renzo"
git config --global user.email "re286estudentupn@gmail.com"
git config --global init.defaultBranch main
```
> Editor por defecto: puede ser Vim, Notepad++, VS Code, etc. Se cambia luego con `git config --global core.editor "<comando>"`.

---

## 1) Crear repositorio local (init) y primer commit
```bat
cd "%USERPROFILE%\Desktop"
md "mi primer project"
cd "mi primer project"
git init
git branch -M main
echo # Mi primer proyecto con Git> README.md
echo .venv/> .gitignore
git status
git add .
git commit -m "chore: init repo con README y .gitignore"
```
**Acción → Producto**
- `git init` crea `.git/` (repo local).  
- `git add` indexa cambios.  
- `git commit` guarda el snapshot con mensaje.

---

## 2) Publicar en GitHub (enlazar remoto y subir)
1. En GitHub: **New repository** → nombre **mi-primer-project** (vacío, sin README).  
2. Enlazar y subir:
```bat
git remote add origin https://github.com/re286estudentupn-svg/mi-primer-project.git
git push -u origin main
```
**Acción → Producto**: rama `main` publicada, visible en GitHub.

---

## 3) Navegación básica e historial
```bat
git status
git log --oneline --graph --decorate --all
git show HEAD
git diff
git diff --staged
```
**Producto**: estado del árbol de trabajo y commits visibles.

---

## 4) Cambios de código + `git add` + `git commit`
```bat
echo Hola Git> hola.txt
git status
git add hola.txt
git commit -m "feat: añadir hola.txt"
git push
```
> Si añadiste algo por error: `git restore --staged <archivo>`

---

## 5) Ramas (branches) y cambio de rama
> Nota: el comando correcto es **`git branch`**, no “got Branch”.
```bat
git branch            & rem lista ramas locales
git branch -a         & rem locales + remotas
git checkout -b feature/saludo   & rem crea y cambia a la rama
echo Linea en feature>> hola.txt
git add hola.txt
git commit -m "feat: ampliar saludo en feature"
git push -u origin feature/saludo
```
**Producto**: rama de trabajo publicada en GitHub.

---

## 6) Fusión (merge) a `main`
```bat
git checkout main
git pull
git merge --no-ff feature/saludo -m "merge: integrar feature/saludo"
git push
```
**Producto**: merge registrado en el historial.  
*(Opcional) Limpieza de la rama ya integrada:*
```bat
git branch -d feature/saludo
git push origin --delete feature/saludo
```

---

## 7) Clonar un repositorio de GitHub a la máquina local
```bat
cd "%USERPROFILE%\Desktop"
git clone https://github.com/re286estudentupn-svg/mi-primer-project.git "mi-primer-project-clone"
cd "mi-primer-project-clone"
git remote -v
git branch -a
git log --oneline --graph --decorate --all --max-count=5
```
**Producto**: copia local funcional con remoto `origin` configurado.

---

## 8) Evidencias requeridas (Acción → Producto)
Incluye capturas de pantalla de:
1. `git status` (en `main`, árbol limpio).  
2. `git log --oneline --graph --decorate --all` donde se vea el **merge**.  
3. `git branch -a` (que muestre `main` y/o `origin/feature/saludo`).  
4. `git remote -v` con la URL del repo.  
5. Salida de `git clone …` y `git log …` en la carpeta clonada.  
6. Portada del repo en GitHub mostrando los últimos commits.

**Texto sugerido (para informe):**  
> **Acción:** Inicialicé un repositorio local, realicé el primer commit, publiqué en GitHub, trabajé en la rama `feature/saludo` y la fusioné en `main`. Cloné el repositorio desde GitHub para validar el flujo de colaboración.  
> **Producto:** Repositorio compartido en GitHub, historial con merge visible, capturas de `git status`, `git log --graph`, `git branch -a`, `git remote -v` y del clonado.

---

## 9) Chuleta de comandos
```bat
git status
git add <archivo>         &  git commit -m "mensaje"
git log --oneline --graph --decorate --all
git checkout -b feature/x &  git checkout main
git merge feature/x       &  git branch -d feature/x
git push -u origin rama   &  git pull
```
