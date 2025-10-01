// 페이지 불러오기
function loadPage(page) {
  fetch("/" + page) // templates/ 내부 페이지 불러오기
    .then(res => res.text())
    .then(html => {
      document.getElementById("mainContent").innerHTML = html;

      // 페이지 안에 있는 script 태그 실행
      const scripts = document.getElementById("mainContent").querySelectorAll("script");
      scripts.forEach(oldScript => {
        const newScript = document.createElement("script");
        if (oldScript.src) {
          newScript.src = oldScript.src;
        } else {
          newScript.textContent = oldScript.textContent;
        }
        document.body.appendChild(newScript);
      });
    });
}

// Alert 모달
function showAlert(msg) {
  document.getElementById("alertMessage").innerText = msg;
  new bootstrap.Modal(document.getElementById("alertModal")).show();
}

// Confirm 모달
function showConfirm(msg, onConfirm) {
  document.getElementById("confirmMessage").innerText = msg;
  const modal = new bootstrap.Modal(document.getElementById("confirmModal"));
  modal.show();
  document.getElementById("confirmOkBtn").onclick = () => {
    modal.hide();
    if (typeof onConfirm === "function") onConfirm();
  };
}

// 로그아웃
function logout() {
  showAlert("로그아웃 되었습니다.");
  location.href = "/login"; // 필요 시 수정
}

// 로그인 경과시간 표시
let seconds = 0;
setInterval(() => {
  seconds++;
  let m = String(Math.floor(seconds / 60)).padStart(2, "0");
  let s = String(seconds % 60).padStart(2, "0");
  document.getElementById("timer").textContent = `${m}:${s}`;
}, 1000);

// 첫 페이지 자동 로드
document.addEventListener("DOMContentLoaded", () => {
  loadPage("dashboard.html");
});
