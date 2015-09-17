<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
  <meta charset="utf-8">
  <title>wordcloud2.js - tag cloud/Wordle presentation on 2D canvas or HTML</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- Le styles -->
  <style>
  @media (min-width: 980px) {
    body { padding-top: 60px; }
  }

  *[hidden] {
    display: none;
  }

  #canvas-container {
    overflow-x: auto;
    overflow-y: visible;
    position: relative;
    margin-top: 20px;
    margin-bottom: 20px;
  }
  .canvas {
    display: block;
    position: relative;
    overflow: hidden;
  }

  .canvas.hide {
    display: none;
  }

  #html-canvas > span {
    transition: text-shadow 1s ease, opacity 1s ease;
    -webkit-transition: text-shadow 1s ease, opacity 1s ease;
    -ms-transition: text-shadow 1s ease, opacity 1s ease;
  }

  #html-canvas > span:hover {
    text-shadow: 0 0 10px, 0 0 10px #fff, 0 0 10px #fff, 0 0 10px #fff;
    opacity: 0.5;
  }

  #box {
    pointer-events: none;
    position: absolute;
    box-shadow: 0 0 200px 200px rgba(255, 255, 255, 0.5);
    border-radius: 50px;
    cursor: pointer;
  }

/*  textarea {
    height: 20em;
  } */
  
  #config-option {
    font-family: monospace;
  }
  select { width: 100%; }

  #loading {
    animation: blink 2s infinite;
    -webkit-animation: blink 2s infinite;
  }
  @-webkit-keyframes blink {
    0% { opacity: 1; }
    100% { opacity: 0; }
  }
  @keyframes blink {
    0% { opacity: 1; }
    100% { opacity: 0; }
  }

  </style>
  <script type="text/javascript">
    if (window.location.hostname === 'timdream.org') {
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-4623408-2']);
      _gaq.push(['_trackPageview']);
    }

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();

  </script>
</head>
  <div class="container">
  <div class="row">
		<div class="12u">
		    <section class="box" style="margin-bottom:7px;">
			    <h3>
			        <strong>Words Cloud of ${ movie } </strong>
			    </h3>
			</section>
			<section class="box special">

    <div id="not-supported" class="alert" hidden>
      <strong>Your browser is not supported.</strong>
    </div>
      <div class="row">
          <div class="12u" id="canvas-container" style="width:100%;">
          <canvas id="canvas" class="canvas"></canvas>
          <div id="html-canvas" class="canvas hide"></div>
        </div>
        <div class="row" style="float:center">
          <a class="button big alt" id="btn-save" href="#" download="wordcloud.png"
              title="Save canvas" style="float:center">Save Image</a>
          <span id="loading" hidden>......</span>
        </div>
      </div>
      <div class="tabbable" style="display:none;">
        <div class="tab-content">
              <div id="input-list"></div>
              <input type="number" id="config-width" class="input-small" min="1">
              <input type="number" id="config-height" class="input-small" min="1">
              <input type="number" id="config-dppx" class="input-mini" min="1" value="1" required>
            <input type="url" id="config-css" size="40" class="input-xxlarge" placeholder="https://fonts.googleapis.com/css?family=Libre+Baskerville:700" value="https://fonts.googleapis.com/css?family=Finger+Paint">
        </div>
      </div>
      </section>
  </div>
  </div>
  </div>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.2.2/bootstrap.min.js"></script>
  <script src="./js/wordcloud2.js"></script>
  <script>
  jQuery(function ($) {
    var $canvas = $('#canvas');
    var $htmlCanvas = $('#html-canvas');
    var $canvasContainer = $('#canvas-container');
    var $loading = $('#loading');

    var $list = $('#input-list');
    var $options = $('#config-option');
    var $width = $('#config-width');
    var $height = $('#config-height');
    var $dppx = $('#config-dppx');
    var $css = $('#config-css');
    var $webfontLink = $('#link-webfont');


    var $box = $('<div id="box" hidden />');
    $canvasContainer.append($box);
    window.drawBox = function drawBox(item, dimension) {
        if (!dimension) {
            $box.prop('hidden', true);

            return;
        }

        var dppx = $dppx.val();

        $box.prop('hidden', false);
        $box.css({
            left: dimension.x / dppx + 'px',
            top: dimension.y / dppx + 'px',
            width: dimension.w / dppx + 'px',
            height: dimension.h / dppx + 'px'
        });
    };

    // Update the default value if we are running in a hdppx device

    $canvas.on('wordcloudstop', function wordcloudstopped(evt) {
        $loading.prop('hidden', true);
    });


    $('#btn-save').on('click', function save(evt) {
        var url = $canvas[0].toDataURL();
        if ('download' in document.createElement('a')) {
            this.href = url;
            } else {
            evt.preventDefault();
            alert('Please right click and choose "Save As..." to save the generated image.');
            window.open(url, '_blank', 'width=500,height=300,menubar=yes');
        }
    });

    $('#btn-canvas').on('click', function showCanvas(evt) {
        $canvas.removeClass('hide');
        $htmlCanvas.addClass('hide');
        $('#btn-canvas').prop('disabled', true);
        $('#btn-html-canvas').prop('disabled', false);
    });

    $('#btn-html-canvas').on('click', function showCanvas(evt) {
        $canvas.addClass('hide');
        $htmlCanvas.removeClass('hide');
        $('#btn-canvas').prop('disabled', false);
        $('#btn-html-canvas').prop('disabled', true);
    });

    $('#btn-canvas').prop('disabled', true);
    $('#btn-html-canvas').prop('disabled', false);

    var $examples = $('#examples');
    $examples.on('change', function loadExample(evt) {
        changeHash(this.value);

        this.selectedIndex = 0;
        $examples.blur();
    });

    var run = function run() {
        $loading.prop('hidden', false);

        // Load web font
        $webfontLink.prop('href', $css.val());

        // devicePixelRatio
        var devicePixelRatio = parseFloat($dppx.val());

        // Set the width and height
        var width = $width.val() ? $width.val() : $('#canvas-container').width();
        var height = $height.val() ? $height.val() : Math.floor(width * 0.65);
        var pixelWidth = width;
        var pixelHeight = height;

        if (devicePixelRatio !== 1) {
            $canvas.css({'width': width + 'px', 'height': height + 'px'});

            pixelWidth *= devicePixelRatio;
            pixelHeight *= devicePixelRatio;
            } else {
            $canvas.css({'width': '', 'height': '' });
        }

        $canvas.attr('width', pixelWidth);
        $canvas.attr('height', pixelHeight);

        $htmlCanvas.css({'width': pixelWidth + 'px', 'height': pixelHeight + 'px'});

        // Set the options object
        var options = {};
        if ($options.val()) {
            options = (function evalOptions() {
                try {
                    return eval('(' + $options.val() + ')');
                    } catch (error) {
                    alert('The following Javascript error occurred in the option definition; all option will be ignored: \n\n' +
                    error.toString());
                    return {};
                }
            })();
        }

        // Set devicePixelRatio options
        if (devicePixelRatio !== 1) {
            if (!('gridSize' in options)) {
                options.gridSize = 8;
            }
            options.gridSize *= devicePixelRatio;

            if (options.origin) {
                if (typeof options.origin[0] == 'number')
                options.origin[0] *= devicePixelRatio;
                if (typeof options.origin[1] == 'number')
                options.origin[1] *= devicePixelRatio;
            }

            if (!('weightFactor' in options)) {
                options.weightFactor = 1;
            }
            if (typeof options.weightFactor == 'function') {
                var origWeightFactor = options.weightFactor;
                options.weightFactor =
                function weightFactorDevicePixelRatioWrap() {
                    return origWeightFactor.apply(this, arguments) * devicePixelRatio;
                };
                } else {
                options.weightFactor *= devicePixelRatio;
            }
        }

        // Put the word list into options
        if ($list.val()) {
            var list = [];
            $.each($list.val().split('\n'), function each(i, line) {
                if (!$.trim(line))
                return;

                var lineArr = line.split(' ');
                var count = parseFloat(lineArr.shift()) || 0;
                list.push([lineArr.join(' '), count]);
            });
            options.list = list;
        }

        // All set, call the WordCloud()
        // Order matters here because the HTML canvas might by
        // set to display: none.
        WordCloud([$canvas[0], $htmlCanvas[0]], options);
    };

    var loadExampleData = function loadExampleData(name) {
        var example = examples[name];

        $options.val(example.option || '');
        $list.val(example.list || '');
        $css.val(example.fontCSS || '');
        $width.val(example.width || '');
        $height.val(example.height || '');
    };

    var changeHash = function changeHash(name) {
        if (window.location.hash === '#' + name ||
        (!window.location.hash && !name)) {
            // We got a same hash, call hashChanged() directly
            hashChanged();
            } else {
            // Actually change the hash to invoke hashChanged()
            window.location.hash = '#' + name;
        }
    };

    var hashChanged = function hashChanged() {
        var name = window.location.hash.substr(1);
        if (!name) {
            // If there is no name, run as-is.
            run();
            } else if (name in examples) {
            // If the name matches one of the example, load it and run it
            loadExampleData(name);
            run();
            } else {
            // If the name doesn't match, reset it.
            window.location.replace('#');
        }
    }

    $(window).on('hashchange', hashChanged);

    if (!window.location.hash ||
    !(window.location.hash.substr(1) in examples)) {
        // If the initial hash doesn't match to any of the examples,
        // or it doesn't exist, reset it to #love
        window.location.replace('#wordFreq');
        } else {
        hashChanged();
    }
});

var examples = {
    'wordFreq': {
        list: 
        <c:forEach var="entry" items="${wordFreq}">
            '<c:out value="${entry.value*5 + 16}"/> <c:out value="${entry.key}"/>\n' +
        </c:forEach>
        '',
        option: '{\n' +
            '  gridSize: 18,\n' +
            '  weightFactor: 3,\n' +
            '  fontFamily: \'Average, Times, serif\',\n' +
            '  color: function() {\n' +
                '    return ([\'#d0d0d0\', \'#e11\', \'#44f\'])[Math.floor(Math.random() * 3)]\n' +
                '  },\n' +
            '  backgroundColor: \'#333\'\n' +
            '}',
        fontCSS: 'https://fonts.googleapis.com/css?family=Average'
    }
};
  </script>
