# Java Table Group Project

## Nice, nakapasok ka na! Git tayo ngayon. 🎉

Dito natin ilalagay lahat ng code natin para hindi na tayo nagpapasahan ng files sa chat. Sundan mo lang 'to every time na may ia-add kang bagong code.

> **Rule #1:** Huwag mag-push directly sa `master`. Laging gumawa ng sarili mong branch.

---

## Bago magsimula (one time lang)

1. **I-install ang Git:** https://git-scm.com/downloads
2. **Siguraduhing naka-invite ka sa repo.** Check mo yung email o GitHub notifications mo at i-accept. Kapag hindi, hindi ka makaka-push.
3. **I-clone ang repo** sa terminal ng VS Code (o kahit anong IDE mo):

```
git clone https://github.com/Gogggy/Java-table-group-ewan.git
cd Java-table-group-ewan
```

Kapag nag-clone ka, naka-connect na agad yung folder mo sa GitHub, kaya hindi mo na kailangan ng `git remote add`.

> **Nauna mo bang ginawa yung project sa laptop mo (hindi nag-clone)?** Kailangan mo munang i-connect sa repo natin. Gawin mo 'to nang isang beses lang:
> ```
> git remote add origin https://github.com/Gogggy/Java-table-group-ewan.git
> ```

---

## Every time na may ia-add kang code

### 1. Gumawa ng bagong branch

Gumagawa tayo lagi ng bagong branch para kung may bug yung code mo, hindi maaapektuhan yung main code natin.

```
git switch master
git pull
git switch -c <pangalan-ng-feature>
```

Halimbawa: `git switch -c add-factorial`. Walang space sa pangalan, gumamit ng dash (`-`).

- `git pull` ay kumukuha ng pinakabagong code ng team para hindi ka mag-conflict.
- `git switch -c` ay gumagawa ng branch **at** lumilipat agad doon.

### 2. Mag-code na!

Basta nasa branch mo ka, safe ka. 😎

### 3. `git add .`

Pagkatapos mo mag-code, kailangan mong piliin yung mga files na ico-commit. Mostly yung buong folder naman, kaya i-run mo lang sa terminal:

```
git add .
```

Ia-add nito lahat ng binago mo.

### 4. `git commit -m "message"`

Dito mo ise-save yung mga ginawa mo sa **local copy** mo. Dapat may **quotes** yung message, at isulat mo kung ano yung ginawa mo:

```
git commit -m "Add factorial method"
```

### 5. `git push -u origin <pangalan-ng-branch>`

Ito na, ipapadala na natin sa GitHub yung ginawa mo. Sa **unang push** ng bagong branch, ito yung gamitin:

```
git push -u origin add-factorial
```

Kapag nag-push ka ulit sa **parehong branch**, `git push` na lang.

### 6. Gumawa ng Pull Request

Pagkatapos mong mag-push:

1. Pumunta sa GitHub repo natin.
2. Lalabas yung **Compare & pull request** na button. I-click mo.
3. Lagyan ng maikling description kung ano yung ginawa mo.
4. Click **Create pull request**.

Rereviewhin ko muna para sigurado na tama, tapos ako na yung magme-merge sa main. 👍

---

## Mga error na baka makita mo

| Error | Ibig sabihin / Solusyon |
|---|---|
| `The current branch has no upstream branch` | Bagong branch kasi. Gamitin mo `git push -u origin <pangalan-ng-branch>` |
| `remote origin already exists` | Okay na, naka-connect na. Skip mo na yung `git remote add` |
| `Permission denied` / `403` | Hindi ka pa naka-invite sa repo. Message mo ko |
| `CONFLICT` pagkatapos mag-pull | May ibang nag-edit ng parehong file. Message mo ko, aayusin natin |
| `nothing to commit` | Wala ka pang binabago, o nakalimutan mong i-save yung file |

**Tip:** Kapag di ka sure kung nasaan ka na, i-run mo `git status`. Sasabihin nito kung anong branch ka at kung ano yung mga nabago mo.
