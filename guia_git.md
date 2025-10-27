
# Guía documentada de Git y GitHub — *Práctica de Campo*
 (re286estudentupn-svg)  
**Curso:** Técnicas de programación orientada a objetos  

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
cd ALEX\Desktop"
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
cd ALEX\Desktop"
git clone https://github.com/re286estudentupn-svg/mi-primer-project.git "mi-primer-project-clone"
cd "mi-primer-project-clone"
git remote -v
git branch -a
git log --oneline --graph --decorate --all --max-count=5
```
**Producto**: copia local funcional con remoto `origin` configurado.


